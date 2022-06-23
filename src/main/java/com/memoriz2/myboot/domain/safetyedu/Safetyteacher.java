package com.memoriz2.myboot.domain.safetyedu;

import com.memoriz2.myboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Safetyteacher extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stSeq;

    private String stId;

    private String stTel;

/*    private String stMobile;

    private String stZip;

    private String stAddr1;

    private String stAddr2;

    private String stEmail;

    private String stEduLast;

    private String stCategory;

    private String stPhoto;

    private String stPhotoPath;*/

    @Builder
    public Safetyteacher(String stId, String stTel
                         //        , String stMobile, String stZip, String stAddr1, String stAddr2, String stEmail, String stEduLast, String stCategory, String stPhoto, String stPhotoPath
        ){
        this.stId = stId;
        this.stTel = stTel;
//        this.stMobile = stMobile;
//        this.stZip = stZip;
//        this.stAddr1 = stAddr1;
//        this.stAddr2 = stAddr2;
//        this.stEmail = stEmail;
//        this.stEduLast = stEduLast;
//        this.stCategory = stCategory;
//        this.stPhoto = stPhoto;
//        this.stPhotoPath = stPhotoPath;
    }

    public void update(String stId, String stTel){
        this.stId = stId;
        this.stTel = stTel;
    }
}

//todo prefix 붙여서 컬럼 만들기