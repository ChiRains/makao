package com.qcloud.component.file.service.impl;

import java.util.List;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qcloud.component.autoid.AutoIdGenerator;
import com.qcloud.pirates.data.Page;
import com.qcloud.pirates.util.AssertUtil;
import com.qcloud.component.file.dao.FileInformationDao;
import com.qcloud.component.file.model.FileInformation;
import com.qcloud.component.file.service.FileInformationService;
import com.qcloud.component.file.model.query.FileInformationQuery;
import com.qcloud.component.filesdk.FileSDKClient;

@Service
public class FileInformationServiceImpl implements FileInformationService {

    @Autowired
    private FileInformationDao  fileInformationDao;

    @Autowired
    private AutoIdGenerator     autoIdGenerator;

    @Autowired
    private FileSDKClient       fileSDKClient;

    private static final String ID_KEY = "file_file_information";

    @Override
    public boolean add(FileInformation fileInformation) {

        FileInformation information = fileInformationDao.getByCode(fileInformation.getCode());
        AssertUtil.assertTrue(information == null, "code编码已存在." + fileInformation.getCode());
        long id = autoIdGenerator.get(ID_KEY);
        fileInformation.setId(id);
        return fileInformationDao.add(fileInformation);
    }

    @Override
    public FileInformation get(Long id) {

        return fileInformationDao.get(id);
    }

    @Override
    public boolean delete(Long id) {

        return fileInformationDao.delete(id);
    }

    @Override
    public boolean update(FileInformation fileInformation) {

        FileInformation information = fileInformationDao.getByCode(fileInformation.getCode());
        AssertUtil.assertTrue(information != null, "文件信息不存在." + fileInformation.getCode());
        if(StringUtils.isNotEmpty(fileInformation.getUrl())){
            fileInformation.setUrl(fileSDKClient.uidToUrl(fileInformation.getUrl()));
        }
        return fileInformationDao.update(fileInformation);
    }

    @Override
    public Page<FileInformation> page(FileInformationQuery query, int start, int count) {

        return fileInformationDao.page(query, start, count);
    }

    public List<FileInformation> listAll() {

        return fileInformationDao.listAll();
    }

    @Override
    public FileInformation getByCode(String code) {

        return fileInformationDao.getByCode(code);
    }
}
