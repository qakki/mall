package club.lightingsummer.mall.user.controller;

import club.lightingsummer.mall.api.bean.UmsMember;
import club.lightingsummer.mall.api.bean.UmsMemberReceiveAddress;
import club.lightingsummer.mall.api.service.UserService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
@Controller
public class UserController {

    @Reference(interfaceClass = UserService.class, check = false)
    private UserService userService;

    @RequestMapping(path = "/index", method = RequestMethod.GET)
    @ResponseBody
    public List<UmsMember> index() {
        return userService.getAllUsers();
    }

    @RequestMapping(path = "/getUserReceiveAddress")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getUserReceiveAddress(@RequestParam("id") String memberId) {
        return userService.getReceiveAddressByMemberId(memberId);
    }
}
