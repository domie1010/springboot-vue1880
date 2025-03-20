package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WuzhushensuDao;
import com.entity.WuzhushensuEntity;
import com.service.WuzhushensuService;
import com.entity.vo.WuzhushensuVO;
import com.entity.view.WuzhushensuView;

@Service("wuzhushensuService")
public class WuzhushensuServiceImpl extends ServiceImpl<WuzhushensuDao, WuzhushensuEntity> implements WuzhushensuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzhushensuEntity> page = this.selectPage(
                new Query<WuzhushensuEntity>(params).getPage(),
                new EntityWrapper<WuzhushensuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzhushensuEntity> wrapper) {
		  Page<WuzhushensuView> page =new Query<WuzhushensuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WuzhushensuVO> selectListVO(Wrapper<WuzhushensuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WuzhushensuVO selectVO(Wrapper<WuzhushensuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WuzhushensuView> selectListView(Wrapper<WuzhushensuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzhushensuView selectView(Wrapper<WuzhushensuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
