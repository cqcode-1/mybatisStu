package com.john.plus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;

import org.apache.ibatis.reflection.MetaObject;

import java.time.LocalDateTime;

public class MyMetaObjectHandler implements MetaObjectHandler {
   @Override
   public void insertFill(MetaObject metaObject) {
      this.strictInsertFill(metaObject, "ename", String.class, "ajv"); // 起始版本 3.3.0(推荐使用)
   }

   @Override
   public void updateFill(MetaObject metaObject) {
      this.strictUpdateFill(metaObject, "ename", String.class, "sjbv"); // 起始版本 3.3.0(推荐)
   }
}
