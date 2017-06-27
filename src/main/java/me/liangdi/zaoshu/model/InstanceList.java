package me.liangdi.zaoshu.model;

import lombok.Data;

import java.util.List;

/**
 * 实例列表
 * Created by liangdi on 6/27/17.
 */
@Data
public class InstanceList extends ApiResult{
    List<Instance.InstanceData> data;
}
