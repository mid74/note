function addShare(){
var $li=$(this).parents("li")
var noteId=$li.data("noteId")
$.ajax({
	url:path+"/share/add.do",
	type:"post",
	data:{"noteId":noteId},
	dataType:"json",
	success:function(result){
		if(result.status==0){
			//获取文本内容
			var noteTitle=$li.text();
			var sli="";
			sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
			sli+=noteTitle;
			sli+='<i class="fa fa-chevron-down"></i>'
			sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
			sli+='</a>'
			//将笔记li元素<a>标记内容替换
			$li.find("a").html(sli);
			alert("笔记分享成功")
		}
	},
	error:function(){
		alert("失败")
		}
	})
}

function sure_addNote(){
//获取请求参数
var userId=getCookie("userId");
var title=$("#input_note").val();
var $li=$("#book_ul a.checked").parent();
var bookId=$li.data("bookId");
var ok=true;
if(title==""){
	ok=false;
	$("#title_span").html("标题不能为空");
}
if(userId==null){//检查是否失效
	ok=false;
	window.location.href="login_in.html";
}
//发送ajax请求
if(ok){
	$.ajax({
		url:path+"/note/add.do",
		type:"post",
		data:{"userId":userId,"bookId":bookId,"title":title},
		dataType:"json",
		success:function(result){
			var note=result.data;
			if(result.status==0){
				var id=note.cn_note_id;
				var title=note.cn_note_title;
				createNoteLi(id,title);
				alert(result.msg);
			}
		},
		error:function(){
			alert("创建笔记失败");
			}
		})
	}
}

//更新笔记
function updateNote(){
//获取参数
var $li=$("#note_ul a.checked").parent();
//获取noteId
console.log($li);
var noteId=$li.data("noteId")
//获取笔记的标题和内容
var noteTitle=$("#input_note_title").val();
var noteBody=um.getContent();
alert(noteId);
$.ajax({
	url:path+"/note/update.do",
	type:"post",
	data:{"noteId":noteId,"noteTitle":noteTitle,"noteBody":noteBody},
	dataType:"json",
	success:function(result){
		if(result.status==0){
			var str="";
			str='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
			str+=noteTitle;
			str+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
			//将字符串更新到li的a元素里
			$li.find("a").html(str);
			alert(result.msg); 
		}
	},
	error:function(){
		alert("保存笔记失败");
		}
	});
}

//显示笔记信息
function loadnote(){ 	
	$("#note_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	var noteId=$(this).data("noteId");
	$.ajax({
		url:path+"/note/load.do",
		type:"post",
		data:{"noteId":noteId},
		dataType:"json",
		success:function(result){
				if(result.status==0){
				//获取返回的笔记标题
				var title=result.data.cn_note_title;
				//获取返回的笔记内容
				var body=result.data.cn_note_body;
				//设置笔记标题
				$("#input_note_title").val(title);
				//设置笔记内容
				um.setContent(body);
			}
		},
		error:function(){
			alert("错误");
		}
	});
}

//加载笔记本
function loadBookNotes(){
	//设置选中效果
	$("#book_ul a").removeClass("checked");
	$(this).find("a").addClass("checked");
	$("#pc_part_2").show();
	$("#pc_part_6").hide()
	var bookId=$(this).data("bookId");
	//alert(bookId);	`
	$.ajax({
		url:path+"/note/loadnotes.do",
		type:"post",
		data:{"bookId":bookId},
		dataType:"json",
		success:function(result){
			var notes=result.data;
			if(result.status==0){
				//清除原列表信息
				$("#note_ul").empty();
				for(var i=0;i<notes.length;i++){
					//获取比较ID
					var noteId=notes[i].cn_note_id;
					//获取笔记标题
					var title=notes[i].cn_note_title;
					createNoteLi(noteId,title);
				}
				
			}
		},
		error:function(){
			alert("错误");
		}		
	})
}


function createNoteLi(noteId,title){
	var sli="";
	sli+='<li class="online">';
	sli+='<a >';
	sli+='<i class="fa fa-file-text-o" title="online" rel="tooltip-bottom"></i>';
	sli+=title;
	sli+='<button type="button" class="btn btn-default btn-xs btn_position btn_slide_down"><i class="fa fa-chevron-down"></i></button>';	
	sli+='</a>';
	sli+='<div class="note_menu" tabindex="-1">';
	sli+='<dl>';
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_move" title="移动至..."><i class="fa fa-random"></i></button></dt>';		
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_share" title="分享"><i class="fa fa-sitemap"></i></button></dt>';		
	sli+='<dt><button type="button" class="btn btn-default btn-xs btn_delete" title="删除"><i class="fa fa-times"></i></button></dt>';		
	sli+='</dl>';	
	sli+='</div>';
	sli+='</li>';
	//转换成jQuery对象 
	var $li=$(sli);
	// 像元素附加信息
	$li.data("noteId",noteId);
	$("#note_ul").append($li);
}