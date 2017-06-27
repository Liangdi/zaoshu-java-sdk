package me.liangdi.zaoshu.model;

import lombok.Data;

import java.util.List;

/**
 * 任务列表对象
 * Created by liangdi on 6/27/17.
 */
@Data
public class TaskList extends ApiResult{

    List<Task.TaskData> data;

}
