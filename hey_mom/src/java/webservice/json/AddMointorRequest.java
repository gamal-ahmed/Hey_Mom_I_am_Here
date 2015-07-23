/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice.json;

import dao.model.Organization;
import dao.model.StMo;
import dao.model.Student;
import java.util.Collection;


/**
 *
 * @author ahaleem
 */

public class AddMointorRequest {
   private Integer id;

    private String name;
    private Organization orgId;
    private String email;
    private String mobile;
    private String homePhone;
    private String facebook;
    private String twitter;
    private String postion;
    private Collection<StMo> stMoCollection;

  

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

  public Organization getOrgId() {
        return orgId;
    }

    public void setOrgId(Organization orgId) {
        this.orgId = orgId;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

   
    public Collection<StMo> getStMoCollection() {
        return stMoCollection;
    }

    public void setStMoCollection(Collection<StMo> stMoCollection) {
        this.stMoCollection = stMoCollection;
    }



    
}
