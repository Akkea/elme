<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh_CN">
<head>
    <meta charset="utf-8">
    <title>商家列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0,
    minimum-scale=1.0, maximum-scale=1.0, user-scalable=0">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/layuiadmin/layui/css/layui.css" media="all">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/layuiadmin/style/admin.css" media="all">
    <style>
        .toppadding{
            padding-top: 10px;
        }
        .shaixuan{
            width: 50px;
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="layui-card layadmin-header">
    <div class="layui-breadcrumb" lay-filter="breadcrumb">
        <a lay-href="">主页</a>
        <a><cite>组件</cite></a>
        <a><cite>数据表格</cite></a>
        <a><cite>简单用法</cite></a>
    </div>
</div>

<div class="layui-fluid">
    <div class="layui-row layui-col-space15">
        <div class="layui-col-md12">
            <div class="layui-card">
                <div class="layui-card-header">商家列表</div>
                <div class="layui-card-body">
                    <form class="layui-form" action="" lay-filter="component-form-group">
                        <div class="layui-inline toppadding">
                            <div class="layui-form-item">
                            <label class="layui-form-label">商家名字</label>
                            <div class="layui-input-block">
                                <input type="text" name="title" lay-verify="title" autocomplete="off"
                                       placeholder="请输入商家名字" class="layui-input">
                            </div>
                        </div>
                        </div>
                        <div class="layui-inline toppadding">
                            <div class="layui-form-item">
                            <label class="layui-form-label">商家类型</label>
                            <div class="layui-input-block">
                                <select name="interest" lay-filter="aihao">
                                    <option value="" selected>所有类型</option>
                                    <option value="1">早餐</option>
                                    <option value="2">午餐</option>
                                    <option value="3">晚餐</option>
                                </select>
                            </div>
                        </div>
                        </div>
                        <div class="layui-inline toppadding">
                            <div class="layui-form-item">
                                <label class="layui-form-label">商家状态</label>
                                <div class="layui-input-block">
                                    <input type="checkbox" name="like[write]" value="1" title="未审核">
                                    <input type="checkbox" name="like[read]" value="2" title="正常">
                                    <input type="checkbox" name="like[game]" value="3" title="封禁">
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline toppadding  shaixuan">
                            <button type="button" class="layui-btn">筛选</button>
                        </div>
                    </form>
                    <table class="layui-hide" id="business-list"></table>
                </div>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/layuiadmin/layui/layui.js"></script>
<script>
    layui.config({
        base: '${pageContext.request.contextPath}/layuiadmin/' //静态资源所在路径
    }).extend({
        index: 'lib/index' //主入口模块
    }).use(['index', 'table'], function(){
        let table = layui.table;
        table.render({
            //表格选择器
            elem: '#business-list'
            ,url: '${pageContext.request.contextPath}/business/listPage'
            ,cols: [[
                {type:'checkbox'},
                {type:'numbers', title: '序号'},
                {field:'storeName', title: '商家名字'},
                {field:'storeAddress', title: '商家地址'},
                {field:'storeBlurb', title: '简介'},
                {field:'mainImage', title: '商家图片'},
                {title: '商家类型' , templet:function (data) {
                    return data.orderType.typeValue;
                    }},
                {field:'startPrice', title: '起送费'},
                {field:'deliveryPrice', title: '配送费'},
                {field:'storeRemarks', title: '备注'},
                {title: '状态',templet:function (data) {
                    return data.storeStatus.statusValues;}},
            ]],
            //设置传回的分页分页数量和分页大小名字，与Controller保持一致
            request:{
                pageName:'pageNum',
                limitName : 'pageSize'
            },
            // 工具条开启
            toolbar:'default',
            //分页功能
            page : true,
            //默认分页
            limit:5,
            //设置分页间距
            limits : [5,10,15,20,30]
        })
    });
</script>
</body>
</html>
