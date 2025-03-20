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


import com.dao.ZukepingjiaDao;
import com.entity.ZukepingjiaEntity;
import com.service.ZukepingjiaService;
import com.entity.vo.ZukepingjiaVO;
import com.entity.view.ZukepingjiaView;

@Service("zukepingjiaService")
public class ZukepingjiaServiceImpl extends ServiceImpl<ZukepingjiaDao, ZukepingjiaEntity> implements ZukepingjiaService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZukepingjiaEntity> page = this.selectPage(
                new Query<ZukepingjiaEntity>(params).getPage(),
                new EntityWrapper<ZukepingjiaEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZukepingjiaEntity> wrapper) {
		  Page<ZukepingjiaView> page =new Query<ZukepingjiaView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZukepingjiaVO> selectListVO(Wrapper<ZukepingjiaEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZukepingjiaVO selectVO(Wrapper<ZukepingjiaEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZukepingjiaView> selectListView(Wrapper<ZukepingjiaEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZukepingjiaView selectView(Wrapper<ZukepingjiaEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
