//按回车，加载搜索结果的第一页
function sureSearchShare(event){
var code=event.keyCode;
if(code=13){
	//获取请求参数
	var keyword=$("#search_note").val();
	page=1;
	//发送ajax请求
		loadPageShare(keyword,page)
	}
}
//按更多按钮，加载查询结果的下一页
function moreSearchShare(){
	//获取参数
	var keyword=$("#search_note").val();
	page=page+1;
	//发送ajax请求加载列表
	loadPageShare(keyword,page);
};

function loadPageShare(keyword,page){
	$.ajax({
			url:path+"/share/search.do",
			type:"post",
			data:{"keyword":keyword,"page":page},
			dataType:"json",
			success:function(result){
				var shares=result.data;
				for(var i=0;i<shares.length;i++){
					//记录shareid
					var shareId=shares[i].cn_share_id;
					//获取sharetitle
					var shareTitle=shares[i].cn_share_title;
					//获取li对象
					var sli="";
					sli+='<li class="online">';
					sli+='<a >';
					sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
					sli+=shareTitle;
					sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
					sli+='</a>';
					sli+='</li>'
					var $li=$(sli);
					//绑定shareId
					$li.data("shareId",shareId);  								
					//将li对象添加到ul当中
					$("#search_ul").append($li); 
					//切换显示区
					$("#pc_part_2").hide();
					$("#pc_part_6").show();
				}
			},
			error:function(){
				alert("搜索失败")
			}
		})
}