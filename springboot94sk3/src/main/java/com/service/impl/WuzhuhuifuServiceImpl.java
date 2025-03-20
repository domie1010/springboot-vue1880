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


import com.dao.WuzhuhuifuDao;
import com.entity.WuzhuhuifuEntity;
import com.service.WuzhuhuifuService;
import com.entity.vo.WuzhuhuifuVO;
import com.entity.view.WuzhuhuifuView;

@Service("wuzhuhuifuService")
public class WuzhuhuifuServiceImpl extends ServiceImpl<WuzhuhuifuDao, WuzhuhuifuEntity> implements WuzhuhuifuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WuzhuhuifuEntity> page = this.selectPage(
                new Query<WuzhuhuifuEntity>(params).getPage(),
                new EntityWrapper<WuzhuhuifuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WuzhuhuifuEntity> wrapper) {
		  Page<WuzhuhuifuView> page =new Query<WuzhuhuifuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<WuzhuhuifuVO> selectListVO(Wrapper<WuzhuhuifuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WuzhuhuifuVO selectVO(Wrapper<WuzhuhuifuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WuzhuhuifuView> selectListView(Wrapper<WuzhuhuifuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WuzhuhuifuView selectView(Wrapper<WuzhuhuifuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
