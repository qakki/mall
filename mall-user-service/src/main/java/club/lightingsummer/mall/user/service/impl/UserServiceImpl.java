package club.lightingsummer.mall.user.service.impl;

import club.lightingsummer.mall.api.bean.UmsMember;
import club.lightingsummer.mall.api.bean.UmsMemberReceiveAddress;
import club.lightingsummer.mall.api.service.UserService;
import club.lightingsummer.mall.user.mapper.UmsMemberReceiveAddressMapper;
import club.lightingsummer.mall.user.mapper.UserMapper;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author lightingSummer
 * @date 2019/11/11 0011
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Autowired
    UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId) {
        Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId", memberId);
        return umsMemberReceiveAddressMapper.selectByExample(e);
    }
}
