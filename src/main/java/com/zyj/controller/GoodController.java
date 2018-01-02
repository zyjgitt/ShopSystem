package com.zyj.controller;

import com.zyj.pojo.*;
import com.zyj.service.GoodService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
public class GoodController {
    @Resource
    private GoodService goodService;
    @Resource
    private Good good;
    @Resource
    private GoodDetail goodDetail;

    //跳转到saveSupplier页面
    @RequestMapping("/enterFunction/{name}")
    public ModelAndView enterFunction(@PathVariable(value = "name") String name) throws Exception{
        ModelAndView mav = new ModelAndView();
        if(name.equals("supplier")){
            mav.setViewName("/WEB-INF/jsp/saveSupplier.jsp");
        }else if(name.equals("good")) {
            //查商品种类
            List<GoodType> types = goodService.selAllGoodType();
            //查供货商
            List<Supplier> suppliers = goodService.selAllSupplier();
            //  System.out.println(types);

            mav.getModel().put("types", types);
            mav.getModel().put("suppliers", suppliers);
            mav.setViewName("/WEB-INF/jsp/saveGood.jsp");
        }else {
            mav.setViewName("/WEB-INF/jsp/saveGoodDetail.jsp");
        }
        return mav;
    }
    @RequestMapping("/enterFunction2/{name}")
    public String enterFunction2(@PathVariable(value = "name") String name,HttpServletRequest request) throws Exception{
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(name.equals("selGoodMess")){
            request.setAttribute("storeName",user.getUsername());
        }
        return "redirect:selGoodByStore";
    }

    @RequestMapping("/enterSpecFunction/{name}/{code}")
    public ModelAndView enterSpecFunction(@PathVariable String name,@PathVariable String code) throws Exception{
        ModelAndView mav = new ModelAndView();
        if(name.equals("goodDetail")){
            mav.getModel().put("code",code);
            mav.setViewName("/WEB-INF/jsp/saveGoodDetail.jsp");
        }
        return mav;
    }
    //添加商品类型
    public ModelAndView saveGoodType(GoodType goodType) throws Exception{
        ModelAndView mav = new ModelAndView();
        Random ra = new Random();
        StringBuffer sb= null;
        for(int i=0;i<6;i++){
            int num=ra.nextInt(9);
            sb.append(num);
        }
        char c=(char)(Math.random()*26+97);
        String code = c+"_"+sb.toString();

        goodType.setTypeCode(code);
        goodService.saveGoodType(goodType);
        mav.setViewName("/WEB-INF/jsp/saveGoodType.jsp");
        return mav;
    }

  @RequestMapping("/saveSupplier")
    public ModelAndView saveSupplier(Supplier supplier) throws Exception{
        ModelAndView mav = new ModelAndView();
        System.out.println("name:"+supplier.getName());
        supplier.setCreateTime(new Date());
        goodService.saveSupplier(supplier);
        System.out.println(supplier);
        mav.setViewName("/WEB-INF/jsp/saveSupplier.jsp");
        return mav;
    }

    @RequestMapping("/saveGood")
    public String saveGood(String code,String name,Double price,String briefCode,int typeId,int supplierId,
                                 String storeName,String ifGift,String ifReturn,MultipartFile imgFile, HttpServletRequest request/*,RedirectAttributes attr*/) throws Exception{
        System.out.println("---saveGood---");

        String oldName = imgFile.getOriginalFilename().toString();
        String newName = UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
        String path = request.getSession().getServletContext().getRealPath("/")+"/images/"+newName;
        System.out.println("path:::"+path);
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        imgFile.transferTo(file);
        String http = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+request.getContextPath()+"/images/"+newName;
        System.out.println(http);


        Date date  = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String regDate = format.format(date);


        good.setImgUrl(http);
        good.setRegisterDate(regDate);
        good.setCode(code);
        good.setName(name);
        good.setPrice(price);
        good.setBriefCode(briefCode);
        good.setTypeId(typeId);
        good.setSupplierId(supplierId);
        good.setStoreName(storeName);
        good.setIfGift(ifGift);
        good.setIfReturn(ifReturn);
        goodService.saveGood(good);
        //attr.addAttribute("storeName",storeName);
        return "redirect:selGoodByStore";
    }
    @RequestMapping("/selGoodByStore")
    public ModelAndView selGoodByStore(HttpServletRequest request/*,String storeName*/) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<Good> goods = goodService.selAllGoodByStore(user.getUsername());
        mav.getModel().put("goods",goods);

        mav.setViewName("/WEB-INF/jsp/showGood.jsp");
        return mav;
    }

    @RequestMapping("/selGoodDetailByStore")
    public ModelAndView selGoodDetailByStore(HttpServletRequest request) throws Exception{
        ModelAndView mav = new ModelAndView();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        List<GoodDetail> goodDetails = goodService.selGoodDetailByStore(user.getUsername());

       // System.out.println(goodDetails);

        mav.getModel().put("goodDetails",goodDetails);
        System.out.println();

        mav.setViewName("/WEB-INF/jsp/showGoodDetail.jsp");
        return mav;
    }

    @RequestMapping("/selGoodALLMessage/{name}")
    public ModelAndView selGoodALLMessage(@PathVariable String name) throws Exception{
        ModelAndView mav = new ModelAndView();

        List<Good> goods = goodService.selGoodALLMessage(name);
        mav.getModel().put("goods",goods);

        mav.setViewName("/WEB-INF/jsp/showGoodALLMessage.jsp");
        return mav;
    }

    @RequestMapping("/saveGoodDetail")
    public ModelAndView saveGood(String  goodCode,String goodDetailCode,String description,Double costPrice,Double salePrice,int num,MultipartFile imgFile, HttpServletRequest request) throws Exception{
        System.out.println("---saveGoodDetail---");
//goodCode,goodDetailCode,description,costPrice,salePrice,num,imgUrl,createTime
        ModelAndView mav = new ModelAndView();
        String oldName = imgFile.getOriginalFilename().toString();
        String newName = UUID.randomUUID()+oldName.substring(oldName.lastIndexOf("."));
        String path = request.getSession().getServletContext().getRealPath("/");
        path = path+"/images/"+newName;
        System.out.println(path);
        File file = new File(path);
        if(!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }

        imgFile.transferTo(file);
        String http = request.getScheme()+"://"+request.getServerName()+":"+
                request.getServerPort()+request.getContextPath()+"/images/"+newName;

        goodDetail.setGoodCode(goodCode);
        goodDetail.setGoodDetailCode(goodDetailCode);
        goodDetail.setDescription(description);
        goodDetail.setCostPrice(costPrice);
        goodDetail.setSalePrice(salePrice);
        goodDetail.setImgUrl(http);
        System.out.println(http);
        goodDetail.setNum(num);


        Date date  = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String time = format.format(date);

        goodDetail.setCreateTime(time);
        System.out.println(goodDetail);
        goodService.saveGoodDetail(goodDetail);
        mav.getModel().put("num",1);
        mav.getModel().put("code",goodCode);
        mav.setViewName("/WEB-INF/jsp/saveGoodDetail.jsp");
        return mav;
    }

    @RequestMapping("/selAllGoodByType/{id}")
    public ModelAndView selAllGoodByType(@PathVariable int id) throws Exception{
        ModelAndView mav = new ModelAndView();
        List<Good> goods = goodService.selAllGoodByType(id);
        mav.getModel().put("goods",goods);

        mav.setViewName("/WEB-INF/jsp/showGoodsByType.jsp");
        return mav;
    }
    @RequestMapping("/selGoodDetailByGoodCode/{code}")
    public ModelAndView selGoodDetailByGoodCode(@PathVariable String code) throws Exception{
        ModelAndView mav = new ModelAndView();
        Good good = goodService.selGoodDetailByGoodCode(code);
        System.out.println(good.getGoodDetails());
        mav.getModel().put("good",good);
        mav.getModel().put("code",code);
        mav.setViewName("/WEB-INF/jsp/showGoodDetailsByCode.jsp");
        return mav;
    }
  /*  @RequestMapping("selNum")
    public @ResponseBody  GoodDetail selNum(String code, String desc) throws Exception{
        ModelAndView mav = new ModelAndView();

        GoodDetail goodDetail = goodService.selNum(code,desc);
        return goodDetail;
    }*/
  @RequestMapping("/sc")
  public ModelAndView sc(ShopCart shopCart) throws Exception{
      ModelAndView mav = new ModelAndView();
      System.out.println(shopCart);
      goodService.saveShopCart(shopCart);

      Good good = goodService.selGoodDetailByGoodCode(shopCart.getGoodCode());
      mav.getModel().put("good",good);
      mav.getModel().put("code",shopCart.getGoodCode());
      mav.getModel().put("rows",1);
      mav.setViewName("/WEB-INF/jsp/showGoodDetailsByCode.jsp");
      return mav;
  }


}
