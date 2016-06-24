package com.qcloud.project.macaovehicle.web.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.snaker.engine.access.QueryFilter;
import org.snaker.engine.entity.Process;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import com.qcloud.component.filesdk.FileSDKClient;
import com.qcloud.component.form.web.controller.FormController;
import com.qcloud.component.form.web.form.Form;
import com.qcloud.component.form.web.form.NotionForm;
import com.qcloud.component.organization.QClerk;
import com.qcloud.component.organization.web.helper.ClerkHelper;
import com.qcloud.component.snaker.web.FormGetter;
import com.qcloud.component.snaker.web.controller.helper.ProcessHelper;
import com.qcloud.pirates.mvc.FrontAjaxView;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.project.macaovehicle.exception.MacaovehicleException;
import com.qcloud.project.macaovehicle.model.CarOwner;
import com.qcloud.project.macaovehicle.model.CarOwnerAcquisition;
import com.qcloud.project.macaovehicle.model.CarOwnerEnterprisers;
import com.qcloud.project.macaovehicle.model.CarOwnerHousers;
import com.qcloud.project.macaovehicle.model.CarOwnerPurchase;
import com.qcloud.project.macaovehicle.model.CarOwnerTalent;
import com.qcloud.project.macaovehicle.model.CarOwnerWorkers;
import com.qcloud.project.macaovehicle.model.Driver;
import com.qcloud.project.macaovehicle.model.LoginForm;
import com.qcloud.project.macaovehicle.model.ProcessProgress;
import com.qcloud.project.macaovehicle.model.Vehicle;
import com.qcloud.project.macaovehicle.model.key.TypeEnum;
import com.qcloud.project.macaovehicle.model.key.TypeEnum.ProgressState;
import com.qcloud.project.macaovehicle.service.CarOwnerAcquisitionService;
import com.qcloud.project.macaovehicle.service.CarOwnerEnterprisersService;
import com.qcloud.project.macaovehicle.service.CarOwnerHousersService;
import com.qcloud.project.macaovehicle.service.CarOwnerPurchaseService;
import com.qcloud.project.macaovehicle.service.CarOwnerService;
import com.qcloud.project.macaovehicle.service.CarOwnerTalentService;
import com.qcloud.project.macaovehicle.service.CarOwnerWorkersService;
import com.qcloud.project.macaovehicle.service.DriverService;
import com.qcloud.project.macaovehicle.service.ProcessProgressService;
import com.qcloud.project.macaovehicle.service.VehicleService;
import com.qcloud.project.macaovehicle.web.form.AllCarOwnerForm;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerAcquisitionHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerEnterprisersHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerHousersHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerPurchaseHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerTalentHandler;
import com.qcloud.project.macaovehicle.web.handler.CarOwnerWorkersHandler;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerAcquisitionVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerEnterprisersVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerHousersVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerTalentVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerVO;
import com.qcloud.project.macaovehicle.web.vo.CarOwnerWorkersVO;

@Controller
@RequestMapping(value = CarOwnerController.DIR)
public class CarOwnerController {

	public static final String DIR = "/carOwner";

	private static final Logger log = LoggerFactory.getLogger(CarOwnerController.class);

	@Autowired
	private CarOwnerService carOwnerService;

	@Autowired
	private CarOwnerHandler carOwnerHandler;

	@Autowired
	private CarOwnerEnterprisersService carOwnerEnterprisersService;

	@Autowired
	private CarOwnerEnterprisersHandler carOwnerEnterprisersHandler;

	@Autowired
	private CarOwnerHousersService carOwnerHousersService;

	@Autowired
	private CarOwnerHousersHandler carOwnerHousersHandler;

	@Autowired
	private CarOwnerWorkersService carOwnerWorkersService;

	@Autowired
	private CarOwnerWorkersHandler carOwnerWorkersHandler;

	@Autowired
	private CarOwnerTalentService carOwnerTalentService;

	@Autowired
	private CarOwnerTalentHandler carOwnerTalentHandler;

	@Autowired
	private CarOwnerPurchaseService carOwnerPurchaseService;

	@Autowired
	private CarOwnerPurchaseHandler carOwnerPurchaseHandler;

	@Autowired
	private CarOwnerAcquisitionService carOwnerAcquisitionService;

	@Autowired
	private CarOwnerAcquisitionHandler carOwnerAcquisitionHandler;

	@Autowired
	private ClerkHelper clerkHelper;

	@Autowired
	private MacaoUserController macaoUserController;

	@Autowired
	private DriverService driverService;

	@Autowired
	private VehicleService vehicleService;

	@Autowired
	private FormController formController;

	@Autowired
	private ProcessHelper processHelper;
	@Autowired
	private ProcessProgressService processProgressService;
	@Autowired
	private FormGetter formGetter;

	@Autowired
	private FileSDKClient fileSDKClient;

	@RequestMapping
	public FrontAjaxView myInfo(HttpServletRequest request) {

		QClerk user = clerkHelper.getClerkModel(request);
		CarOwner carOwner = carOwnerService.getByClerk(user.getId());
		AssertUtil.assertNotNull(carOwner, "用户信息不完整." + user.getId());
		long carOwnerId = carOwner.getId();
		List<ProcessProgress> progressList = processProgressService.listByCarOwnerId(carOwnerId);
		// 默认允许编辑个人资料
		boolean writable = true;
		for (ProcessProgress processProgress : progressList) {
			// 申请步骤中，只要未完成且没有被拒绝，就不可以编辑个人资料
			if (processProgress.getState() == 1) {
				writable = false;
				break;
			}
		}
		CarOwnerVO carOwnerVO = carOwnerHandler.toVO(carOwner);
		carOwnerVO.setHeadImage(user.getHeadImage());
		//
		if (carOwner.getClerkType() == TypeEnum.OwnerType.PERSON.getKey()) {
			if (carOwner.getType() == TypeEnum.UserType.WORKERS.getKey()) {
				CarOwnerWorkers workers = carOwnerWorkersService.getByCarOwner(carOwnerVO.getId());
				CarOwnerWorkersVO workersVO = carOwnerWorkersHandler.toVO(workers);
				carOwnerVO.setWorkersVO(workersVO);
			}
			if (carOwner.getType() == TypeEnum.UserType.HOUSERS.getKey()) {
				CarOwnerHousers housers = carOwnerHousersService.getByCarOwner(carOwnerVO.getId());
				CarOwnerHousersVO housersVO = carOwnerHousersHandler.toVO(housers);
				carOwnerVO.setHousersVO(housersVO);
			}
			if (carOwner.getType() == TypeEnum.UserType.TALENT.getKey()) {
				CarOwnerTalent talent = carOwnerTalentService.getByCarOwner(carOwnerVO.getId());
				CarOwnerTalentVO talentVO = carOwnerTalentHandler.toVO(talent);
				carOwnerVO.setTalentVO(talentVO);
			}
			if (carOwner.getType() == TypeEnum.UserType.ACQUISITION.getKey()) {
				CarOwnerAcquisition acquisition = carOwnerAcquisitionService.getByCarOwner(carOwnerVO.getId());
				CarOwnerAcquisitionVO acquisitionVO = carOwnerAcquisitionHandler.toVO(acquisition);
				carOwnerVO.setAcquisitionVO(acquisitionVO);
			}
		}
		if (carOwner.getClerkType() == TypeEnum.OwnerType.BUSINESS.getKey()) {
			if (carOwner.getType() == TypeEnum.UserType.ENTERPRISERS.getKey()) {
				CarOwnerEnterprisers enterprisers = carOwnerEnterprisersService.getByCarOwner(carOwnerVO.getId());
				CarOwnerEnterprisersVO enterprisersVO = carOwnerEnterprisersHandler.toVO(enterprisers);
				carOwnerVO.setEnterprisersVO(enterprisersVO);
			}
			if (carOwner.getType() == TypeEnum.UserType.ACQUISITION.getKey()) {
				CarOwnerAcquisition acquisition = carOwnerAcquisitionService.getByCarOwner(carOwnerVO.getId());
				CarOwnerAcquisitionVO acquisitionVO = carOwnerAcquisitionHandler.toVO(acquisition);
				CarOwnerEnterprisers carOwnerEnterprisers = carOwnerEnterprisersService
						.getByCarOwner(carOwnerVO.getId());
				CarOwnerEnterprisersVO carOwnerEnterprisersVO = carOwnerEnterprisersHandler.toVO(carOwnerEnterprisers);
				carOwnerVO.setEnterprisersVO(carOwnerEnterprisersVO);
				carOwnerVO.setAcquisitionVO(acquisitionVO);
			}
		}
		FrontAjaxView view = new FrontAjaxView();
		view.addObject("edit", writable);// 是否可以编辑个人资料
		view.addObject("carOwner", carOwnerVO);
		return view;
	}

	@RequestMapping
	public FrontAjaxView addAllInfo(HttpServletRequest request, AllCarOwnerForm carOwnerForm) {

		FrontAjaxView view = new FrontAjaxView();
		AssertUtil.assertNotNull(carOwnerForm.getVehicle(), "车辆信息不能为空.");
		AssertUtil.assertTrue(carOwnerForm.getDriver().size() > 0, "驾驶员信息至少有一个.");
		QClerk user = clerkHelper.getClerkModel(request);
		LoginForm loginForm = carOwnerForm.getLoginForm();
		AssertUtil.assertNotNull(loginForm.getEmail(), "邮箱不能为空.");
		AssertUtil.assertNotNull(loginForm.getMobile(), "电话不能为空.");
		AssertUtil.greatZero(loginForm.getClerkType(), "角色类别不能为空.");
		AssertUtil.greatZero(loginForm.getType(), "类型不能为空.");
		// 车辆信息验证
		Vehicle vehicle = carOwnerForm.getVehicle();
		AssertUtil.assertNotNull(vehicle.getPlateNumber(), "车牌号不能为空.");
		Vehicle temp = vehicleService.getByPlateNumber(vehicle.getPlateNumber());
		AssertUtil.assertTrue(temp == null, "车牌号已存在." + vehicle.getPlateNumber());
		// 新增账号
		loginForm.setPassword("123456");
		long carOwnerId = carOwnerService.add(loginForm);
		if (carOwnerId > 0) {
			log.info("审批端注册门户网账号成功." + loginForm.getMobile());
			if (add4Type(carOwnerId, loginForm)) {
				List<Driver> driverList = carOwnerForm.getDriver();
				String drivers = "";
				for (Driver driver : driverList) {
					driver.setCarOwnerId(carOwnerId);
					driverService.add(driver);
					drivers = drivers + driver.getId() + ",";
				}
				vehicle.setCarOwnerId(carOwnerId);
				vehicleService.add(vehicle);
				// 申请入境
				// Form form = new Form();
				// Process process = processHelper.getProcess("approve");
				// form.setProcessId(process.getId());
				// form.setFormId(formGetter.getForm(process));
				// formController.save(request, form, new NotionForm());
				view.setMessage("添加成功.");
				view.addObject("drivers", drivers.substring(0, drivers.length() - 1));
				view.addObject("vehicle", vehicle.getId());
				view.addObject("carOwnerId", carOwnerId);
			}
		}
		return view;
	}

	private boolean add4Type(Long carOwnerId, LoginForm form) {

		CarOwner carOwner = carOwnerService.get(carOwnerId);
		carOwner.setResidence(form.getResidence());
		carOwner.setIdcardNumber(form.getIdcardNumber());
		carOwner.setIdcardFace(fileSDKClient.uidToUrl(form.getIdcardFace()));
		carOwner.setIdcardBack(fileSDKClient.uidToUrl(form.getIdcardBack()));
		carOwner.setAddress(form.getAddress());
		carOwner.setName(form.getName());
		carOwner.setSex(form.getSex());
		carOwner.setCertificateType(form.getCertificateType());
		carOwner.setCertificateDate(form.getCertificateDate());
		// 多张图片
		if (form.getCertificateUrls().size() > 0) {
			String certificateUrls = "";
			for (String certificateUrl : form.getCertificateUrls()) {
				certificateUrls = certificateUrls + fileSDKClient.uidToUrl(certificateUrl) + ",";
			}
			if (!StringUtils.isEmpty(certificateUrls)) {
				certificateUrls = certificateUrls.substring(0, certificateUrls.length() - 1);
			}
			carOwner.setCertificateUrl(certificateUrls);
		}
		carOwner.setCertificateNo(form.getCertificateNo());
		carOwner.setIdCardValidTime(form.getIdCardValidTime());
		if (carOwner.getType() == 0) {
			carOwner.setType(form.getType());
		}
		carOwner.setBirthday(form.getBirthday());
		//
		CarOwnerWorkers workers = form.getWorkers();
		CarOwnerHousers housers = form.getHousers();
		CarOwnerEnterprisers enterprisers = form.getEnterprisers();
		CarOwnerTalent talent = form.getTalent();
		CarOwnerPurchase purchase = form.getPurchase();
		CarOwnerAcquisition acquisition = form.getAcquisition();
		return carOwnerService.update(carOwner, workers, housers, enterprisers, talent, purchase, acquisition);
	}
}
