function loadUserBooks(){
	var userId=getCookie("userId");
	if(userId==null){
		window.location.href("log_in.html");
	}else{
		$.ajax({
			url:path+"/book/loadbooks.do",
			type:"post",
			data:{"userId":userId},
			dataType:"json",
			success:function(result){
				//判断查询是否成功
				if(result.status==0){
					//获取笔记本集合
					var books=result.data;
					for(var i=0;i<books.length;i++){
						//获取笔记本ID
						var bookId=books[i].cn_notebook_id;
						//获取笔记本名称
						var bookName=books[i].cn_notebook_name;
						//创建一个笔记本列表的li元素
						creatBookLi(bookId,bookName);
					}
				}
			},
			error:function(){
				alert("笔记本加载失败");
			}
		});
	}
};

//创建一个笔记本li元素
function creatBookLi(bookId,bookName){
	var sli="";
	sli+='<li class="online">';
	sli+='<a>';
    sli+='<i class="fa fa-book" title="online" rel="tooltip-bottom">';
    sli+='</i>';
	sli+=bookName;
	sli+='</a></li>'
	//将sli字符串转换成jquery对象的li元素
	var $li=$(sli);
	//将bookId值与jquery对象绑定
	$li.data("bookId",bookId);
	//将li元素添加到笔记本ul列表区
	$("#book_ul").append($li);
}