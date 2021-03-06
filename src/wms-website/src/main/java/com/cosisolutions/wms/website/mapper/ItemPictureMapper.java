package com.cosisolutions.wms.website.mapper;

import com.cosisolutions.wms.website.entity.ItemPictureEntity;
import com.cosisolutions.wms.website.models.ItemPictureModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemPictureMapper implements IMapper<ItemPictureEntity, ItemPictureModel> {
  @Autowired
  private ItemMapper itemMapper;

  @Override
  public void toModel(ItemPictureModel model, ItemPictureEntity entity) {
    if(model == null || entity == null) return;

    model.setId(entity.getId());
    model.setData(entity.getData());

    itemMapper.toModel(model.getItem(), entity.getItem());
  }

  @Override
  public void toEntity(ItemPictureEntity entity, ItemPictureModel model) {
    if(entity == null || model == null) return;

    entity.setData(model.getData());

    if(model.getId() > 0)
      entity.setId(model.getId());

    itemMapper.toEntity(entity.getItem(), model.getItem());
  }
}
