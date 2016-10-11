/**
 * 所有的业务js模板：方法写到执行函数类，将需要暴露的函数扩展到jquery对象上
 * Created by zjh on 2016-06-24.
 */
(function ($) {
    "use strict";
    //方法扩展
    $.extend({
        example_fuc: example_fuc
    });

    /**
     * 方法扩展
     */
    function example_fuc() {
        //do something
    }

}(jQuery || {}));
