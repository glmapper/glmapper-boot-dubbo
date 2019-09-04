//package com.glmapper.bridge.boot.consumer;
//
//import brave.Span;
//import brave.Tracing;
//import com.alibaba.dubbo.common.extension.ExtensionFactory;
//import zipkin2.reporter.Reporter;
//
//
///**
// * @author: guolei.sgl (guolei.sgl@antfin.com) 2019/8/29 5:47 PM
// * @since:
// **/
//public class TracingExtensionFactory implements ExtensionFactory {
//
//    @Override
//    public <T> T getExtension(Class<T> type, String name) {
//        if (type != Tracing.class) {
//            return null;
//        }
//        return (T) Tracing.newBuilder()
//                .localServiceName("my-service")
//                .spanReporter(new MyReporter())
//                .build();
//    }
//
//    static class MyReporter implements Reporter {
//        @Override
//        public void report(Object span) {
//            System.out.println(span instanceof Span);
//        }
//    }
//}
