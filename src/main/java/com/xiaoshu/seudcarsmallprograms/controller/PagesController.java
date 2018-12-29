package com.xiaoshu.seudcarsmallprograms.controller;

import com.xiaoshu.seudcarsmallprograms.constants.UserConstants;
import com.xiaoshu.seudcarsmallprograms.model.*;
import com.xiaoshu.seudcarsmallprograms.service.*;
import com.xiaoshu.seudcarsmallprograms.service.impl.*;
import com.xiaoshu.seudcarsmallprograms.util.SpringUtil;
import com.xiaoshu.seudcarsmallprograms.util.UserUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/pages")
public class PagesController {

    /***----------------------------dashboard-------------------------------*/

    @RequestMapping("/dashboard")
    public String dashboard(ModelMap map){
        SysUser user = UserUtil.getCurrentUser();
        String passwordEncoder = UserUtil.passwordEncoder(UserConstants.DEFAULT_PASSWORD, user.getSalt());
        map.put("isDefaultPassword",user.getPassword().equals(passwordEncoder));
        return "dashboard";
    }


    /***----------------------------generate-------------------------------*/

    @RequestMapping("/generate")
    public String generate(){
        return "generate/generate";
    }



    /***----------------------------user-------------------------------*/

    @RequestMapping("/user/userList")
    public String user(){
        return "user/userList";
    }

    @RequestMapping("/user/changePassword")
    public String changePassword(){
        return "user/changePassword";
    }

    @RequestMapping("/user/addUser")
    public String addUser(ModelMap map){
        map.put("defaultPassword",UserConstants.DEFAULT_PASSWORD);
        return "user/addUser";
    }
    
    @RequestMapping("/user/updateUser")
    public String updateUser(){
        return "user/updateUser";
    }

    @RequestMapping("/user/updateMyself")
    public String updateMyself(){
        return "user/updateMyself";
    }

    @RequestMapping("/user/updateHeadImg")
    public String updateHeadImg(){
        return "user/updateHeadImg";
    }




   /***------------------------------role----------------*/
   @RequestMapping("/role/roleList")
   public String roleList(){
        return "role/roleList";
    }

    @RequestMapping("/role/addRole")
    public String addRole(){
        return "role/addRole";
    }




    /***-----------------------------menu----------------*/
    @RequestMapping("/menu/menuList")
    public String menuList(){
        return "menu/menuList";
    }

    @RequestMapping("/menu/addMenu")
    public String addMenu(){
        return "menu/addMenu";
    }

    @RequestMapping("/menu/icon")
    public String menuIcon(){
        return "menu/icon";
    }

    @RequestMapping("/menu/updateMenu")
    public String updateMenu(){
        return "menu/updateMenu";
    }




    /***-----------------fileInfo-------------------------*/

    @RequestMapping("/fileInfo/fileInfoList")
    public String fileInfoList(){
        return "file/fileList";
    }




    /***-----------------log-------------------------*/
    @RequestMapping("/log/logList")
    public String logList(){
        return "log/logList";
    }




    /***-----------------dict-------------------------*/
    @RequestMapping("/dict/dictList")
    public String dictList(){
        return "dict/dictList";
    }

    @RequestMapping("/dict/addDict")
    public String addDict(ModelMap map){
        DictService dictService = SpringUtil.getBean(DictServiceImpl.class);
        List<Map<String, String>> maps = dictService.selectAllType();
        Map<String,String> typeNames = new HashMap<>();
        maps.forEach( m -> {
            typeNames.put(m.get("typeName"),m.get("type"));
        });
        map.put("typeNames",typeNames );
        return "dict/addDict";
    }

    @RequestMapping("/dict/updateDict")
    public String updateDict(){
        return "dict/updateDict";
    }


    /***-----------------excel-------------------------*/
    @RequestMapping("/excel/sql")
    public String excelSql(){
        return "excel/sql";
    }

    /***-----------------mail-------------------------*/
    @RequestMapping("/mail/mailList")
    public String mailList(){
        return "mail/mailList";
    }

    @RequestMapping("/mail/addMail")
    public String addMail(){
        return "mail/addMail";
    }

    @RequestMapping("/mail/mailDetail")
    public String mailDetail(){
        return "mail/mailDetail";
    }

    /**-----------------carBasicss-------------------------**/
    @RequestMapping("/carBasicss/carBasicsList")
    public String carBasicsList(){
        return "carBasics/carBasicsList";
    }

    @RequestMapping("/carBasicss/addCarBasics")
    public String addCarBasics(ModelMap map){
        ImsAutopartsCarBrandService brandService = SpringUtil.getBean(ImsAutopartsCarBrandServiceImpl.class);
        DictService dictService = SpringUtil.getBean(DictServiceImpl.class);
        SellerInformationService sellerService = SpringUtil.getBean(SellerInformationServiceImpl.class);
        map.put("carBrands",brandService.selectAll());
        map.put("carLevels",dictService.selectByType("carLevel"));
        map.put("sellers",sellerService.selectAll());
        return "carBasics/addCarBasics";
    }

    @RequestMapping("/carBasicss/updateCarBasics")
    public String updateCarBasics(@RequestParam("id") Long id, ModelMap map){
        ImsAutopartsCarBrandService brandService = SpringUtil.getBean(ImsAutopartsCarBrandServiceImpl.class);
        DictService dictService = SpringUtil.getBean(DictServiceImpl.class);
        SellerInformationService sellerService = SpringUtil.getBean(SellerInformationServiceImpl.class);
        CarBasicsService carBasicsService = SpringUtil.getBean(CarBasicsServiceImpl.class);
        FileService fileService = SpringUtil.getBean(FileServiceImpl.class);
        CarBasics carBasics = carBasicsService.getById(id);
        CarBody carBody =  carBasicsService.selectCarBodyByCarId(id);
        carBody = (carBody == null || carBody.getId() == null ) ? new CarBody(id) : carBody;
        CarEngine carEngine =  carBasicsService.selectCarEngineByCarId(id);
        carEngine = (carEngine == null || carEngine.getId() == null) ? new CarEngine(id) : carEngine;
        SellerInformation sellerInfo = new SellerInformation();
        if(carBasics.getSellerId() != null ) {
            sellerInfo = carBasicsService.selectSellerInfoByCarId(carBasics.getSellerId());
        }
        List<FileInfo> files = fileService.getByCIdAndCType(id,FileInfo.CType.car);
        map.put("carBasics",carBasics);
        map.put("carBody",carBody);
        map.put("carEngine",carEngine);
        map.put("sellerInfo",sellerInfo);
        map.put("files",files);
        map.put("carBrands",brandService.selectAll());
        map.put("carLevels",dictService.selectByType("carLevel"));
        map.put("sellers",sellerService.selectAll());

        return "carBasics/updateCarBasics";
    }

    @RequestMapping("/carBasicss/viewCarBasics")
    public String viewCarBasics(@RequestParam("id") Long id, ModelMap map){
        CarBasicsService carBasicsService = SpringUtil.getBean(CarBasicsServiceImpl.class);
        FileService fileService = SpringUtil.getBean(FileServiceImpl.class);
        CarBasics carBasics = carBasicsService.getById(id);
        CarBody carBody =  carBasicsService.selectCarBodyByCarId(id);
        carBody = (carBody == null || carBody.getId() == null ) ? new CarBody(id) : carBody;
        CarEngine carEngine =  carBasicsService.selectCarEngineByCarId(id);
        carEngine = (carEngine == null || carEngine.getId() == null) ? new CarEngine(id) : carEngine;
        SellerInformation sellerInfo = new SellerInformation();
        if(carBasics.getSellerId() != null ) {
            sellerInfo = carBasicsService.selectSellerInfoByCarId(carBasics.getSellerId());
        }
        List<FileInfo> files = fileService.getByCIdAndCType(id,FileInfo.CType.car);
        map.put("carBasics",carBasics);
        map.put("carBody",carBody);
        map.put("carEngine",carEngine);
        map.put("sellerInfo",sellerInfo);
        map.put("files",files);
        return "carBasics/viewCarBasics";
    }


    /**-----------------sellerInformation-------------------------**/
    @RequestMapping("/sellerInformation/addSellerInformation")
    public String addSellerInformation(){
        return "sellerInformation/addSellerInformation";
    }

    @RequestMapping("/sellerInformation/sellerInformationList")
    public String sellerInformationList(){
        return "sellerInformation/sellerInformationList";
    }

    @RequestMapping("/sellerInformation/updateSellerInformation")
    public String updateSellerInformation(){
        return "sellerInformation/updateSellerInformation";
    }
}
