package com.qcloud.component.snakerext.web.vo;
public class MemberVO {
    private Long        id;
    private String      name;
    private CharacterVO characterVO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterVO getCharacterVO() {
        return characterVO;
    }

    public void setCharacterVO(CharacterVO characterVO) {
        this.characterVO = characterVO;
    }
}
