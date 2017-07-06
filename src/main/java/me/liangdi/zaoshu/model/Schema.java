package me.liangdi.zaoshu.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liangdi on 7/6/17.
 */
@Data
public class Schema extends ApiResult{

    private InstanceSchema data;

    @Data
    public static class InstanceSchema {

        private List<SchemaField> schemas = new ArrayList<>();

        @Data
        public static class SchemaField {
            private String title;
            private String id;
            private String type;
        }
    }
}
