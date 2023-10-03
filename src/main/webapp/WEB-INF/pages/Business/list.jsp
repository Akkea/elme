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
                                <input type="text" autocomplete="on"
                                       placeholder="请输入商家名字" id="store-name" class="layui-input">
                            </div>
                        </div>
                        </div>
                        <div class="layui-inline toppadding">
                            <div class="layui-form-item">
                            <label class="layui-form-label">商家类型</label>
                            <div class="layui-input-block">
                                <select id="order-type">
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
                                <div class="layui-input-block store-status" >
                                    <input type="checkbox"  value="1" title="未审核" checked>
                                    <input type="checkbox"  value="2" title="正常" checked>
                                    <input type="checkbox"  value="3" title="封禁" checked>
                                </div>
                            </div>
                        </div>
                        <div class="layui-inline toppadding  shaixuan" id="query">
                            <button type="button" class="layui-btn">筛选</button>
                        </div>
                    </form>
                    <table class="layui-hide" id="business-list" lay-filter="business-list"></table>
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
        $ = layui.$;
        layer = layui.layer;
        table.render({
            //表格选择器
            id:'businessList'
            ,elem: '#business-list'
            ,url: '${pageContext.request.contextPath}/business/listDynamics'
            ,cols: [[
                {type:'checkbox'},
                {type:'numbers', title: '序号'},
                {field:'storeName', title: '商家名字',edit:'text'},
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
        table.on('edit(business-list)',function (upd){
            //发送ajax请求
            $.ajax({
                type:'post',
                url:'${pageContext.request.contextPath}/business/dynamicsUpdateById',
                data:{
                    id:upd.data.id,
                    storeName:upd.value
                },
                success:function (res){
                    if (res.code ==0){
                        //页面刷新
                        layer.msg('修改成功',{icon:1})
                        table.reloadData('businessList')
                    }else {
                        layer.alert(res.msg,{icon:2})
                    }
                },
            })
        })
        let param={};
        $('#query').click(function (e){
            param = {};
            //获取商家状态
            let storeStatus=$('.store-status input:checked');
            if (storeStatus.length==0){
                layer.alert("至少选择一个类别",{icon: 0});
                return;
            }
            if (storeStatus.length != 3){
                param.storeStatus = '';
                for (let item of storeStatus){
                    param.storeStatus += item.value + ',';
                }
                //去除最后一位“，”
                param.storeStatus = param.storeStatus.substr(0,param.storeStatus.length-1);
            }
            //获取商家名
            let storeName=$('#store-name').val();
            if (storeName.trim()){
                param.storeName=storeName;
            }
            //获取商家类型
            let orderType = $('#order-type option:selected').val();
            if (orderType!=0){
                param.orderType=orderType;
            }
            console.log(param)
            table.reload('businessList',{where:param})
        })
    });
</script>
</body>
</html>
