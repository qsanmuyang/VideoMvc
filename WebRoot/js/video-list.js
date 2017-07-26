var currentPage=1;
var pages;
$('#grade a').map(function(index,item){
	$(item).click(function(){
		var id = $(item).attr('id');
		$(item).addClass('active').siblings().removeClass('active');
		$(item).css("text-decoration","none");
		forsub(id);
		$('#s-all').addClass('active').siblings().removeClass('active');
		
		var url="servlet/courseAjax.do?opr=videoList&grade="+id+"&sub=s-all&currentPage=1";
		videoList(url);
	})
})

$('#subject a').map(function(idnex,item){
	$(item).click(function(){
		$(item).addClass('active').siblings().removeClass('active');
		$(item).css("text-decoration","none");
		
		var sub=$(item).attr("id");
		var grade=$("#grade .active").attr("id");
		var url="servlet/courseAjax.do?opr=videoList&grade="+grade+"&sub="+sub+"&currentPage=1";
//		$(item).attr("href",url);
		
		videoList(url);
	})
})
function goPage(doc1){
	var doc=$(doc1);
	var num=doc.attr("id");
	var grade=$("#grade .active").attr("id");
	var sub=$("#subject .active").attr("id");
	currentPage=num;
	var url="servlet/courseAjax.do?opr=videoList&grade="+grade+"&sub="+sub+"&currentPage="+currentPage;
	videoList(url);
}
function leftPage(){
	var grade=$("#grade .active").attr("id");
	var sub=$("#subject .active").attr("id");
	currentPage--;
	if(currentPage<=0){
		currentPage=pages;
	}
	var url="servlet/courseAjax.do?opr=videoList&grade="+grade+"&sub="+sub+"&currentPage="+currentPage;
	videoList(url);
}
function rightPage(){
	var grade=$("#grade .active").attr("id");
	var sub=$("#subject .active").attr("id");
	currentPage++;
	if(currentPage>pages){
		currentPage=1;
	}
	var url="servlet/courseAjax.do?opr=videoList&grade="+grade+"&sub="+sub+"&currentPage="+currentPage;
	videoList(url);
}


function forsub(g){
	if(g=="g-all"||g=="m3"||g=="h1"||g=="h2"||g=="h3"){
		$("#subject").children().css("display","inline-block");
	}
	if(g=="m1"){
		$('#phy').css("display","none").siblings().css("display","inline-block");
		$('#chem').css("display","none");
	}
	if(g=="m2"){
		$('#chem').css("display","none").siblings().css("display","inline-block");
	}
}
window.onload=function(){
	var url="servlet/courseAjax.do?opr=videoList&grade=g-all&sub=s-all&currentPage=1"
	videoList(url);
}


function videoList(url){
	$("#videoList").empty();
	$.get(url,function(data){
		var allCouList=data.allCouList;
		for(var i=0;i<allCouList.length;i++){
			$("#videoList").append("<div class='col-sm-6 col-md-3'><div class='thumbnail' style='height: 238px;'>"+
					"<div class='couser-card-top'></div><div class='caption'><h3>"+allCouList[i].cname+"</h3>"+
					"<p>"+allCouList[i].cintro+"</p>"+
					"<p style='position: absolute;bottom: 9px;'><a href='#' class='btn btn-primary' role='button'>¥"+allCouList[i].cprice+"</a>"+
					" <a href='servlet/course.do?opr=videoInfo&id="+allCouList[i].c_id+"' class='btn btn-default' role='button'>了解详情</a></p></div></div></div>");
		}
		pages=data.pages;
		$("#pageList").empty();
		if(pages!=0){
		$("#pageList").append("<li><a href='javascript:;' aria-label='Previous' onclick='leftPage()'>"+
				"<span aria-hidden='true'>&laquo;</span></a></li>");
		for(var i=1;i<=pages;i++){
			if(i==currentPage){
				$("#pageList").append("<li><a href='javascript:;' style='background-color:#337ab7;color:#fff;' id='"+i+"' onclick='goPage(this)'>"+i+"</a></li>");
			}else{
			$("#pageList").append("<li><a href='javascript:;' id='"+i+"' onclick='goPage(this)'>"+i+"</a></li>");
			}
		}
		$("#pageList").append("<li><a href='javascript:;' aria-label='Next' onclick='rightPage()'>"+
				"<span aria-hidden='true'>&raquo;</span></a></li>");
		}
	})
}


