<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>社团生活</title>
<link rel="icon" href="static/images/user_images/pande.png">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Exchange Education a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- css files -->
<link href="static/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="static/css/bootstrap.min.css" rel="stylesheet" type="text/css" media="all" />
<link href="static/css/chromagallery.css" rel="stylesheet" type="text/css" media="all" />
<link href="static/css/style.css" rel="stylesheet" type="text/css" media="all" />
<style type="text/css">
#container { width:80%; margin:30px auto; text-align:left; padding:10px; border:1px solid #ccc; height:250px; position:relative; overflow:hidden; font:16px Verdana, Geneva, sans-serif; color:#fff; text-align:left;}
	.noticeList { width:80%; list-style:inside; position:absolute; top:270px; left:10px;}
	.noticeList li { padding-bottom:5px;}
	.noticeList li a { color:#606060; text-decoration:none;}
	.noticeList li a:hover { color:#09F;}
</style>
<!-- /css files -->
<!-- fonts -->
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Viga' rel='stylesheet' type='text/css'>
<!-- /fonts -->
<!-- js files -->
<script src="static/js/modernizr.custom.js"></script>
<script src="static/js/jquery.min.js"></script>
<script src="static/js/speech/jQuery.speech.js"></script>
<script src="static/js/speech/jQuery.speech.min.js"></script>
<script src="static/js/backtotop.js"></script>
<script src="static/js/bootstrap.min.js"></script>
<script src="static/js/SmoothScroll.min.js"></script>
<!-- /js files -->
<script type="text/javascript">
	//格式化时间
	function formatDate(time){
		var date = new Date(time);
		var str = date.getFullYear() + "-";
		str += ((date.getMonth()+1)<10?("0"+(date.getMonth()+1)):(date.getMonth()+1)) +"-" ;
		str += (date.getDate()<10?("0"+ date.getDate()): date.getDate()) +" ";
		return str;
	}
</script>
</head>

<body id="indexspeech.html" data-spy="scroll" data-target=".navbar" data-offset="60">
<!-- Top Bar -->
<section class="top-bar">
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<a href="#index.html" class="logo"><h1>多彩生活</h1></a>
			</div>

			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
				<ul class="social-icons1">

				<c:if test="${sessionScope.user.getUserName() == null}">
					<li class="y-in"><a href="joinLogin" style="{color:#FFFFFF;}">登陆</a></li>
					<li ><a href="joinRegist" style="{color:#FFFFFF;}">注册</a></li>
				</c:if>
				<c:if test="${sessionScope.user.getUserName() != null}">
					<li class="y-in"><a href="joinMemberInfo?username=${sessionScope.user.getUserName() }">欢迎：${sessionScope.user.getUserName() }</a></li>
					<li><a href="loginOut"> | 注销</a></li>
						<li><a href="${pageContext.request.contextPath}/systermManage"> | 系统管理</a></li>
				</c:if>

				</ul>
			</div>

		</div>
	</div>
</section>
<!-- /Top Bar -->
<!-- Navigation Bar -->
<div class="navbar-wrapper">
    <div class="container">
		<nav class="navbar navbar-inverse navbar-static-top cl-effect-21">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
						<span class="sr-only">多彩社团</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
<%--						<li class="active"><a href="#">首页</a></li>--%>
						<li><a href="#about">科技创新</a></li>
						<li><a href="#services">理论研究</a></li>
						<li><a href="#gallery">社会服务</a></li>
						<li><a href="#curriculum">文化宣扬</a></li>
						<li><a href="#contact">体育竞技</a></li>
						<li><a href="#notice">公告</a></li>
					</ul>
				</div>
			</div>
        </nav>
    </div>
</div>
<!-- /Navigation Bar -->
<!-- Banner Section -->
 <!-- Carousel
    ================================================== -->
<div id="myCarousel" class="carousel slide" data-ride="carousel">
	<!-- Indicators -->
    <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner" role="listbox">
        <div class="item active">
			<img class="first-slide" src="static/images/user_images/banner1.jpg" alt="First slide">
			<div class="container">
				<div class="carousel-caption">

				</div>
			</div>
        </div>
        <div class="item">
			<img class="second-slide" src="static/images/user_images/banner2.jpg" alt="Second slide">
			<div class="container">
				<div class="carousel-caption">

				</div>
			</div>
        </div>
        <div class="item">
			<img class="third-slide" src="static/images/user_images/banner3.jpg" alt="Third slide">
			<div class="container">
				<div class="carousel-caption">

				</div>
			</div>
        </div>
    </div>
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
    </a>
</div><!-- /.carousel -->
<!-- /Banner Section -->
<!-- About Section -->
<section class="our-services" id="about">
	<h3 class="text-center slideanim">科技创新类社团</h3>
	<p class="text-center slideanim">科技创新类社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="clubimage0" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="bigclubname0" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=" >化学与社会协会</a></h4>
								<p id="clubname0">化学与社会协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="clubtenet0">
						宗旨：立足化学，服务社会</br>
						简介：社团坚持围绕“立足化学，服务社会”的宗旨，服务同学，服务社会，协会深的学校的认可，曾被评为年度校2001—2002十佳社团
						，2007—2008年，2009-2010,2010-2011年校优秀社团，协会经验丰富，举办了在同学当中产生极大影响的各种形式的技能比赛与交流会
						等活动，组织了保护母亲河启动仪式，趣味实验进小学，爱心包裹项目等，走出校园，走进社会的活动，协会积极参加各类社会活动，
						在2010年陕西省大学生拒绝毒品，阳光生活活动中荣获社团奖二等奖。</br>
						特色活动：手动灵感化学实验技能大赛
                     </p>
				</div>
			</div>
		<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="clubimage1" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="bigclubname1" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">天文地理协会</a></h4>
								<p id="clubname1">天文地理协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="clubtenet1">
					   宗旨：知天文，晓地理</br>
					   简介：只会唱狮子座可不够，你知道天上的狮子座在哪里吗？这可是天文地理协会的拿手好戏了。
					   在矿物标本展，地质灾害知识比赛中晓地理，在关体观测，航天知识演讲里通天文。</br>
					   特色活动：十米星空天文展
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="clubimage2" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="bigclubname2" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">数学应用协会</a></h4>
								<p id="clubname2">数学应用协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="clubtenet2">
						总之：将快乐融入于数学，将数学应用于生活</br>
                        简介：在这里，数学不仅是纸上的方程式，圆锥体，函数，我们用工藤新一侦探思维，用一休哥的头脑快乐的解决，
						在定期开展的数学活动中，在奇妙的数字王国里找寻到另一种挑战与激情。</br>
                        特色活动：数学课堂模拟大赛
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="clubimage3" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="bigclubname3" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">计算机协会</a></h4>
								<p id="clubname3">计算机协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="clubtenet3">
					   宗旨：倡导以人为本，以计算机为媒介，加强信息交流</br>
					   简介：这个时代绝对离不开计算机，于是在这个时代计算机协会应运而生，打字速度不快？没关系！多媒体课件制作不熟练？
					   没关系！想掌握基本的计算机操作？想成为计算机高手？加入我们吧，一切皆有可能。</br>
					   特色活动：PPT课件制作大赛
					</p>
				</div>
			</div>
		</div>
	</div>

</section>
<!-- /About Section -->
<div class="line"></div>
<!-- Our Services -->
<section class="our-services" id="services">
	<h3 class="text-center slideanim">理论研究类社团</h3>
	<p class="text-center slideanim">理论研究类社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="twoclubimage0" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="twobigclubname0" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">English.net 协会</a></h4>
								<p id="twoclubname0">English.net 协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="twoclubtenet0">
					   宗旨:尽一切的努力，让每一个会员都能切实提高英语</br>
					   简介：多年来，协会一直秉承宗旨，为会员打造了多种趣味性高，实用性强的精品活动，如：“新生杯”英语演讲比赛
					   、快乐英语晨读计划。此外，协会携手政法、师大的英语社团开创了“三校英文歌唱大赛”，比赛历时整整一个月，
					   参与率高，影响范围广泛，受到了各校师生一致好评。协会在09—10年获得“陕西省优秀大学生社团”荣誉称号、10—11年获得“校
					   十年合作交流最佳贡献奖”和“芙蓉学子团队合作优秀奖”。
					   获奖名称：第四届陕西省优秀大学生社团</br>
                       特色活动：“三校英文歌唱大赛”活动</br>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="twoclubimage1" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="twobigclubname1" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">天文地理协会</a></h4>
								<p id="twoclubname1">天文地理协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="twoclubtenet1">
					   宗旨：知天文，晓地理</br>
					   简介：只会唱狮子座可不够，你知道天上的狮子座在哪里吗？这可是天文地理协会的拿手好戏了。
					   在矿物标本展，地质灾害知识比赛中晓地理，在关体观测，航天知识演讲里通天文。</br>
					   特色活动：十米星空天文展
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="twoclubimage2" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="twobigclubname2" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">心里学社</a></h4>
								<p id="twoclubname2">心里学社</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="twoclubtenet2">
						宗旨：探索心灵成就自我</br>
						简介：斯金纳，尧洛伊德，闪闪发光的名字从眼前忽然而过。心理学召唤在神秘的深处。
						在这个社团里，心理学可不只是书上的文字。直击心理学、心理案例分析团体心理训练等一系列的社团活动让你叹服。
						“陕西省高校心理类优秀社团”、“西安邮电大学优秀社团”、“2009—2010年度校十佳社团”的他，等你的到来！</br>
						获奖名称：第五届陕西省优秀大学生社团</br>
						特色活动：“阳光之旅”系列心理健康教育活动</br>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="twoclubimage3" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="twobigclubname3" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">计算机协会</a></h4>
								<p id="twoclubname3">计算机协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="twoclubtenet3">
					   宗旨：倡导以人为本，以计算机为媒介，加强信息交流</br>
					   简介：这个时代绝对离不开计算机，于是在这个时代计算机协会应运而生，打字速度不快？没关系！多媒体课件制作不熟练？
					   没关系！想掌握基本的计算机操作？想成为计算机高手？加入我们吧，一切皆有可能。</br>
					   特色活动：PPT课件制作大赛
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our Services -->
<div class="line"></div>
<!-- Our Gallery -->
<section class="our-services" id="gallery">
	<h3 class="text-center slideanim">社会服务类社团</h3>
	<p class="text-center slideanim">社会服务类社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="secondclubimage0"  src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="secondbigclubname0" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">社会调查服务中心协会</a></h4>
								<p id="secondclubname0">社会调查服务中心协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="secondclubtenet0">
					   宗旨：客观真实的反应社会问题，提高社会调差能力</br>
					   简介：他们拥有专业的团队，他们拥有如火的热情，他们始终服务当先，十大周边小摊贩现状的调查。</br>
					   陕西省统计局电话访问等特色活动中，开创出一条社会调查的星光大道。</br>
					   特色活动：挑战杯月系列活动
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="secondclubimage1" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="secondbigclubname1" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">阳光公益社</a></h4>
								<p id="secondclubname1">阳光公益社</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="secondclubtenet1">
					   宗旨：关爱特殊全体，传播爱心公益</br>
					   简介：面对苦难，我们无法掉过头去，关爱特殊人群，帮教劳教人民，帮助艾滋病毒携带者，戒毒者，
					   将爱心的阳光带给每一个需要阳光的人，汇集爱，奉献爱，感受爱，懂得爱，让世间充满爱。阳关公益社，我们在行动。</br>
					   特色活动：各类社会公益活动
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="secondclubimage2" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="secondbigclubname2" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">阳光教育协会</a></h4>
								<p id="secondclubname2">阳光教育协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="secondclubtenet2">
						宗旨:支援西部，现身教育</br>
						简介：在陕西、四川、云南等多个省份留下过支教的足迹，在“红日工程”的指导下为西部教育事业给予支援……为了公益，
						为了教育，他们一直在努力！“省十佳”、全校唯一的“全国百优社团”、“芙蓉学子公益爱心奖”等诸多奖项是对他们努力的最大肯定！
						加入阳光，相信阳光，相信阳光会让你也成为其中发光发热的一员！</br>
						获奖名称：全国百优社团，首届陕西省十佳大学生社团，陕西省大中专生学生志愿者暑期文化、科技、卫生“三下乡”社会时间活动评选
						中“农村构和谐 真情迎奥运”，阳光教育协会贵州实践队荣获陕西省大中专学生志愿者暑期“三下乡”社会实践活动优秀服务团队
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="secondclubimage3" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="secondbigclubname3" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">计算机协会</a></h4>
								<p id="secondclubname3">计算机协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="secondclubtenet3">
					   宗旨：倡导以人为本，以计算机为媒介，加强信息交流</br>
					   简介：这个时代绝对离不开计算机，于是在这个时代计算机协会应运而生，打字速度不快？没关系！多媒体课件制作不熟练？
					   没关系！想掌握基本的计算机操作？想成为计算机高手？加入我们吧，一切皆有可能。</br>
					   特色活动：PPT课件制作大赛
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our Gallery -->
<div class="line"></div>
<!-- Our  curriculum-->
<section class="our-services" id="curriculum">
	<h3 class="text-center slideanim">文化宣扬类社团</h3>
	<p class="text-center slideanim">文化宣扬社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fourclubimage0" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fourbigclubname0" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">三元学社</a></h4>
								<p id="fourclubname0">三元学社</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fourclubtenet0">
					   成立时间：2009年</br>
					   宗旨：人与人，人与自然，人与社会三元和谐</br>
					   简介：这是一个综合性公益实践性社团，获得的荣誉数不胜数，一个字牛！
					   残疾人社区义务支教家教活动，陕西省高校联盟变废为宝环保设计大赛，三大高校心梦计划系列活动，
					   全面诠释了三元学社的精神，两个字和谐，下一个三元人，欢迎你！</br>
				       特色活动：进残疾人社区支教活动，变废为宝大赛
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fourclubimage1" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fourbigclubname1" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">争鸣社</a></h4>
								<p id="fourclubname1">争鸣社</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fourclubtenet1">
					   宗旨:争口才之先，鸣沟通之旅，</br>
					   简介：对答如流的口才，唇枪舌战的较量，你一定很希望来这一展身手。
					   西安邮电大学中英双语演讲比赛、模拟人才招聘会、西安大学生辩论赛等让你领教高手辩驳的技巧，
					   讲座，技巧交流会等活动让你想说、敢说、会说。你踌躇满志？亦或是不善交际？只要对辩论赛感兴趣，
					   你大可以大胆地参与“百家争鸣”！</br>
					   获奖名称：陕西省第二届移动动感地带校园创业大赛三等奖</br>
					   特色活动：“论道华山，百家争鸣”西安大学生辩论赛
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fourclubimage2" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fourbigclubname2" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">数学应用协会</a></h4>
								<p id="fourclubname2">数学应用协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fourclubtenet2">
						总之：将快乐融入于数学，将数学应用于生活</br>
                        简介：在这里，数学不仅是纸上的方程式，圆锥体，函数，我们用工藤新一侦探思维，用一休哥的头脑快乐的解决，
						在定期开展的数学活动中，在奇妙的数字王国里找寻到另一种挑战与激情。</br>
                        特色活动：数学课堂模拟大赛
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fourclubimage3" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fourbigclubname3" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">计算机协会</a></h4>
								<p id="fourclubname3">计算机协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fourclubtenet3">
					   宗旨：倡导以人为本，以计算机为媒介，加强信息交流</br>
					   简介：这个时代绝对离不开计算机，于是在这个时代计算机协会应运而生，打字速度不快？没关系！多媒体课件制作不熟练？
					   没关系！想掌握基本的计算机操作？想成为计算机高手？加入我们吧，一切皆有可能。</br>
					   特色活动：PPT课件制作大赛
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our curriculum -->
<div class="line"></div>
<!-- Our contact -->
<section class="our-services" id="contact">
	<h3 class="text-center slideanim">体育竞技类社团</h3>
	<p class="text-center slideanim">体育竞技类社团概要</p>
	<div class="container">
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fiveclubimage0" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fivebigclubname0" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">健身协会</a></h4>
								<p id="fiveclubname0">健身协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fiveclubtenet0">
					   简介
						健身俱乐部为会员提供丰富多样的健身项目，提供幽雅的健身环境和室外环境，提供会员生理，营养，心理等方面的科学方法，
						不仅可以获得健身的知识，还可以获得快乐的健身体验，从而提高校园文化生活品位，引导健康生活。</br>
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fiveclubimage1" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fivebigclubname1" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">魔术协会</a></h4>
								<p id="fiveclubname1">魔术协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fiveclubtenet1">
					   宗旨：魔术任我行，魅力震四方</br>
					   简介：爱表演，爱幻想，爱魔术，爱得瑟。我们享受变戏法，更擅长娱乐。沉着冷静，魅力四射，
					   我们只想要见证奇迹，斗转星移，移花接木，你我都一样，因为我是MAGICHOME魔术协会。</br>
					   特色活动：魔术比赛
					</p>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fiveclubimage2" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fivebigclubname2" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">排球协会</a></h4>
								<p id="fiveclubname2">排球协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fiveclubtenet2">
						简介
  						排球协会，以“推广排球运动，丰富学生课余生活，活跃校园文化，提高并增强学生综合素质”为宗旨，
						给广大排球爱好者提供广阔的平台，组织相关排球常识的讲座。
					</p>
				</div>
			</div>
			<div class="col-lg-6 col-md-6">
				<div class="serv-details">
					<div class="row">
						<div class="col-sm-6 col-xs-6">
							<img id="fiveclubimage3" src="${pageContext.request.contextPath}" alt="" class="img-responsive slideanim">
						</div>
						<div class="col-sm-6 col-xs-6">
							<div class="serv-img-details slideanim">
								<h4><a id="fivebigclubname3" href="${pageContext.request.contextPath}/SystermManageSelectClub?clubname=">乒乓球协会</a></h4>
								<p id="fiveclubname3">乒乓球协会</p>
							</div>
						</div>
					</div>
				</div>
				<div class="serv-info slideanim speech">
					<p id="fiveclubtenet3">
					   社团宗旨：“乒”出精彩，“羽”乐同行。</br>
				       社团简介：乒乓球拼出精彩，羽毛球与乐同行，该社团是个发扬国球精神，汇聚国球爱好者的社团，
					   社团活动主要有大型各高校联赛，校内的院级联赛或个人赛，及社团内部的教员活动。
					   这些活动的开展既给给优秀爱好者一个宽广的竞技平台，也给普通社员一个提升水平，交流球技的舞台。</br>
					   获奖情况：该社团曾多次荣获校“十佳社团”和“百强支部”称号
					</p>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- /Our contact -->
<!--/notice-->
<section class="our-services" id="notice">
<h3 class="text-center slideanim">活动公告</h3>
<div id="container">
    <ul class="noticeList">
        <li><a id="indexnotice0" href="${pageContext.request.contextPath}/SystermManageSelectNotice?noticename=" title="" target="_Blank">创业协会2016.5.25创客空间活动室   :针对“大众创新万众创业”活动开展相应培训</a></li>
        <li><a id="indexactivity0" href="${pageContext.request.contextPath}/SystermManageSelectActivity?activityname=" title="" target="_blank">计算机协会2016.11.6计算机科研室    :举办大学生“Oracl"甲骨文ACM竞赛</a></li>
        <li><a id="indexnotice1" href="${pageContext.request.contextPath}/SystermManageSelectNotice?noticename=" title="" target="_blank">天文地理协会 2016.10.9教学楼403 :"走进天文，探索奥秘"主题活动，讲解天体观测</a></li>
        <li><a id="indexactivity1" href="${pageContext.request.contextPath}/SystermManageSelectActivity?activityname=" title="" target="_blank">数学应用协会 2016.5.6  教学楼505 :数学课堂知识模拟大赛</a></li>
        <li><a id="indexnotice2" href="${pageContext.request.contextPath}/SystermManageSelectNotice?noticename=" title="" target="_blank">English.net协会 2016.3.20	 成栋教阶三	:“新生杯”英语演讲比赛海选赛</a></li>
        <li><a id="indexactivity2" href="${pageContext.request.contextPath}/SystermManageSelectActivity?activityname=" title="" target="_blank">English.net协会  2016.3.25 成栋教阶三	:“新生杯”英语演讲比赛决赛、颁奖仪式</a></li>
        <li><a id="indexnotice3" href="${pageContext.request.contextPath}/SystermManageSelectNotice?noticename=" title="" target="_blank">心理健康协会 2016.11.11	研楼436 :“阳光之旅”系列心理健康教育活动宣讲会</a></li>
        <li><a id="indexactivity3" href="${pageContext.request.contextPath}/SystermManageSelectActivity?activityname=" title="" target="_blank">阳光公益社	2016.4.28  幸福中心小学  :深入课堂，走进学生身边开展支教活动 </a></li>
    </ul>
</div>

</section>
<!--/notice-->
<!-- Footer Section -->
<section class="footer">
	<h2 class="text-center">THANKS FOR VISITING US</h2>
		<p>
			<a href="http://www.xiyou.edu.cn" target="_blank">西安邮电大学官网</a>|
			<a href="http://www.xiyou.edu.cn/xxfw/cyfw1.htm" target="_blank">西安邮电大学教务处</a>|
		</p><br>
		<p>QQ群号:6666666666</p>
		<div id="Result">
</div>

</section>
<!-- /Footer Section -->
<!-- Back To Top -->
<a href="#0" class="cd-top">Top</a>
<!-- /Back To Top -->
<!-- js files -->

<!-- js files for gallery -->
<script src="static/js/chromagallery.pkgd.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() 
		{
		    $(".mygallery").chromaGallery();
		});
	</script>
<!-- /js files for gallery -->	
<!-- Back To Top -->
<!-- /Back To Top -->
<script>
$(document).ready(function(){
  // Add smooth scrolling to all links in navbar + footer link
  $(".navbar a, footer a[href='#myPage']").on('click', function(event) {

  // Store hash
  var hash = this.hash;

  // Using jQuery's animate() method to add smooth page scroll
  // The optional number (900) specifies the number of milliseconds it takes to scroll to the specified area
  $('html, body').animate({
    scrollTop: $(hash).offset().top
  }, 900, function(){

    // Add hash (#) to URL when done scrolling (default click behavior)
    window.location.hash = hash;
    });
  });
})
</script>
<script>
$(window).scroll(function() {
  $(".slideanim").each(function(){
    var pos = $(this).offset().top;

    var winTop = $(window).scrollTop();
    if (pos < winTop + 600) {
      $(this).addClass("slide");
    }
  });
});
jQuery(function($) {
	function ScrollAction(listObj, speed, isSeries) {	//listObj为需要滚动的列表，  speed为滚动速度
		var pos, top, aniTop, height;
		var id = '';  //记录setInterval的标记id
 
		pos = listObj.position();	
		top = pos.top;			//列表的top
		aniTop = top;				//记录当前运动时的top
		height = listObj.height();	//列表的高度
 
		var scrollUp = function() {
			aniTop--;
			if(!isSeries) {	//isSeries变量控制是否连续滚动，false不连续，true连续
				if(aniTop == -height) {	//不连续，滚动玩重新滚动
					listObj.css({'top': top});
					aniTop = top;
				};
			} else {
				if(aniTop == -listObj.children().eq(0).height()) {	//连续滚动
					var firstItem = '<li>' + listObj.children().eq(0).html() + '</li>';
					listObj.children().eq(0).remove();
					listObj.append(firstItem);
					aniTop = 4;
				};
			};
			listObj.css({'top': aniTop + 'px'});
		};
 
		var hover = function(id) {
			listObj.hover(function() {
				clearInterval(id);
			}, function() {
				id = setInterval(scrollUp, speed);
			});
		};
 
		this.start = function() {
			id = setInterval(scrollUp, speed);
			hover(id);
		};
 
	};
	var sa = new ScrollAction($('.noticeList'), 30, true);
	sa.start();
});

$('.speech>p').speech({
	"speech": true, //通过点击链接播报，还是直接播报
	"lang": "zh", //语言			
	"speed": 3, //语速			
	"sWidth": 16, //链接按钮的宽度			
	"sHeight": 16, //链接按钮的高度		
	"https": true, //启用https	
	"bg": "static/images/user_images/speech.jpg", //链接按钮的背景图片
});


</script>
<!-- /js files -->
<!-- 弹出未登录alert -->
<c:if test="${sessionScope.user==null}">
	<script type="text/javascript"> 
	alert("您尚未登录，请登录后查看");
	window.location.replace("${pageContext.request.contextPath}/pages/user/login.jsp") ;
	
	</script>
</c:if>


</body>
<script>
	<%--打开首页开始加载社团--%>
	window.onload=function (){
		console.log(1)
		$.getJSON("SelectClubByClubClass?clubClass=1",function (date){
			console.log(date)
			document.getElementById("clubimage0").src += date[0].clubImagepath;
			document.getElementById("bigclubname0").innerHTML = date[0].clubName;
			document.getElementById("bigclubname0").href += date[0].clubName;
			document.getElementById("clubname0").innerHTML = date[0].clubName;
			document.getElementById("clubtenet0").innerHTML = '宗旨：'+date[0].clubTenet+'<br>'+'简介:'+date[0].clubIntroduction;
			document.getElementById("clubimage1").src += date[1].clubImagepath;
			document.getElementById("bigclubname1").innerHTML = date[1].clubName;
			document.getElementById("bigclubname1").href += date[1].clubName;
			document.getElementById("clubname1").innerHTML = date[1].clubName;
			document.getElementById("clubtenet1").innerHTML = '宗旨：'+date[1].clubTenet+'<br>'+'简介:'+date[1].clubIntroduction;
			document.getElementById("clubimage2").src += date[2].clubImagepath;
			document.getElementById("bigclubname2").innerHTML = date[2].clubName;
			document.getElementById("bigclubname2").href += date[2].clubName;
			document.getElementById("clubname2").innerHTML = date[2].clubName;
			document.getElementById("clubtenet2").innerHTML = '宗旨：'+date[2].clubTenet+'<br>'+'简介:'+date[2].clubIntroduction;
			document.getElementById("clubimage3").src += date[3].clubImagepath;
			document.getElementById("bigclubname3").innerHTML = date[3].clubName;
			document.getElementById("bigclubname3").href += date[3].clubName;
			document.getElementById("clubname3").innerHTML = date[3].clubName;
			document.getElementById("clubtenet3").innerHTML = '宗旨：'+date[3].clubTenet+'<br>'+'简介:'+date[3].clubIntroduction;
		})
		$.getJSON("SelectClubByClubClass?clubClass=2",function (date){
			console.log(date)
			document.getElementById("twoclubimage0").src += date[0].clubImagepath;
			document.getElementById("twobigclubname0").innerHTML = date[0].clubName;
			document.getElementById("twobigclubname0").href += date[0].clubName;
			document.getElementById("twoclubname0").innerHTML = date[0].clubName;
			document.getElementById("twoclubtenet0").innerHTML = '宗旨：'+date[0].clubTenet+'<br>'+'简介:'+date[0].clubIntroduction;
			document.getElementById("twoclubimage1").src += date[1].clubImagepath;
			document.getElementById("twobigclubname1").innerHTML = date[1].clubName;
			document.getElementById("twobigclubname1").href += date[1].clubName;
			document.getElementById("twoclubname1").innerHTML = date[1].clubName;
			document.getElementById("twoclubtenet1").innerHTML = '宗旨：'+date[1].clubTenet+'<br>'+'简介:'+date[1].clubIntroduction;
			document.getElementById("twoclubimage2").src += date[2].clubImagepath;
			document.getElementById("twobigclubname2").innerHTML = date[2].clubName;
			document.getElementById("twobigclubname2").href += date[2].clubName;
			document.getElementById("twoclubname2").innerHTML = date[2].clubName;
			document.getElementById("twoclubtenet2").innerHTML = '宗旨：'+date[2].clubTenet+'<br>'+'简介:'+date[2].clubIntroduction;
			document.getElementById("twoclubimage3").src += date[3].clubImagepath;
			document.getElementById("twobigclubname3").innerHTML = date[3].clubName;
			document.getElementById("twobigclubname3").href += date[3].clubName;
			document.getElementById("twoclubname3").innerHTML = date[3].clubName;
			document.getElementById("twoclubtenet3").innerHTML = '宗旨：'+date[3].clubTenet+'<br>'+'简介:'+date[3].clubIntroduction;
		})
		$.getJSON("SelectClubByClubClass?clubClass=3",function (date){
			console.log(date)
			document.getElementById("secondclubimage0").src += date[0].clubImagepath;
			document.getElementById("secondbigclubname0").innerHTML = date[0].clubName;
			document.getElementById("secondbigclubname0").href += date[0].clubName;
			document.getElementById("secondclubname0").innerHTML = date[0].clubName;
			document.getElementById("secondclubtenet0").innerHTML = '宗旨：'+date[0].clubTenet+'<br>'+'简介:'+date[0].clubIntroduction;
			document.getElementById("secondclubimage1").src += date[1].clubImagepath;
			document.getElementById("secondbigclubname1").innerHTML = date[1].clubName;
			document.getElementById("secondbigclubname1").href += date[1].clubName;
			document.getElementById("secondclubname1").innerHTML = date[1].clubName;
			document.getElementById("secondclubtenet1").innerHTML = '宗旨：'+date[1].clubTenet+'<br>'+'简介:'+date[1].clubIntroduction;
			document.getElementById("secondclubimage2").src += date[2].clubImagepath;
			document.getElementById("secondbigclubname2").innerHTML = date[2].clubName;
			document.getElementById("secondbigclubname2").href += date[2].clubName;
			document.getElementById("secondclubname2").innerHTML = date[2].clubName;
			document.getElementById("secondclubtenet2").innerHTML = '宗旨：'+date[2].clubTenet+'<br>'+'简介:'+date[2].clubIntroduction;
			document.getElementById("secondclubimage3").src += date[3].clubImagepath;
			document.getElementById("secondbigclubname3").innerHTML = date[3].clubName;
			document.getElementById("secondbigclubname3").href += date[3].clubName;
			document.getElementById("secondclubname3").innerHTML = date[3].clubName;
			document.getElementById("secondclubtenet3").innerHTML = '宗旨：'+date[3].clubTenet+'<br>'+'简介:'+date[3].clubIntroduction;
		})
		$.getJSON("SelectClubByClubClass?clubClass=4",function (date){
			console.log(date)
			document.getElementById("fourclubimage0").src += date[0].clubImagepath;
			document.getElementById("fourbigclubname0").innerHTML = date[0].clubName;
			document.getElementById("fourbigclubname0").href += date[0].clubName;
			document.getElementById("fourclubname0").innerHTML = date[0].clubName;
			document.getElementById("fourclubtenet0").innerHTML = '宗旨：'+date[0].clubTenet+'<br>'+'简介:'+date[0].clubIntroduction;
			document.getElementById("fourclubimage1").src += date[1].clubImagepath;
			document.getElementById("fourbigclubname1").innerHTML = date[1].clubName;
			document.getElementById("fourbigclubname1").href += date[1].clubName;
			document.getElementById("fourclubname1").innerHTML = date[1].clubName;
			document.getElementById("fourclubtenet1").innerHTML = '宗旨：'+date[1].clubTenet+'<br>'+'简介:'+date[1].clubIntroduction;
			document.getElementById("fourclubimage2").src += date[2].clubImagepath;
			document.getElementById("fourbigclubname2").innerHTML = date[2].clubName;
			document.getElementById("fourbigclubname2").href += date[2].clubName;
			document.getElementById("fourclubname2").innerHTML = date[2].clubName;
			document.getElementById("fourclubtenet2").innerHTML = '宗旨：'+date[2].clubTenet+'<br>'+'简介:'+date[2].clubIntroduction;
			document.getElementById("fourclubimage3").src += date[3].clubImagepath;
			document.getElementById("fourbigclubname3").innerHTML = date[3].clubName;
			document.getElementById("fourbigclubname3").href += date[3].clubName;
			document.getElementById("fourclubname3").innerHTML = date[3].clubName;
			document.getElementById("fourclubtenet3").innerHTML = '宗旨：'+date[3].clubTenet+'<br>'+'简介:'+date[3].clubIntroduction;
		})
		$.getJSON("SelectClubByClubClass?clubClass=5",function (date){
			console.log(date)
			document.getElementById("fiveclubimage0").src += date[0].clubImagepath;
			document.getElementById("fivebigclubname0").innerHTML = date[0].clubName;
			document.getElementById("fivebigclubname0").href += date[0].clubName;
			document.getElementById("fiveclubname0").innerHTML = date[0].clubName;
			document.getElementById("fiveclubtenet0").innerHTML = '宗旨：'+date[0].clubTenet+'<br>'+'简介:'+date[0].clubIntroduction;
			document.getElementById("fiveclubimage1").src += date[1].clubImagepath;
			document.getElementById("fivebigclubname1").innerHTML = date[1].clubName;
			document.getElementById("fivebigclubname1").href += date[1].clubName;
			document.getElementById("fiveclubname1").innerHTML = date[1].clubName;
			document.getElementById("fiveclubtenet1").innerHTML = '宗旨：'+date[1].clubTenet+'<br>'+'简介:'+date[1].clubIntroduction;
			document.getElementById("fiveclubimage2").src += date[2].clubImagepath;
			document.getElementById("fivebigclubname2").innerHTML = date[2].clubName;
			document.getElementById("fivebigclubname2").href += date[2].clubName;
			document.getElementById("fiveclubname2").innerHTML = date[2].clubName;
			document.getElementById("fiveclubtenet2").innerHTML = '宗旨：'+date[2].clubTenet+'<br>'+'简介:'+date[2].clubIntroduction;
			document.getElementById("fiveclubimage3").src += date[3].clubImagepath;
			document.getElementById("fivebigclubname3").innerHTML = date[3].clubName;
			document.getElementById("fivebigclubname3").href += date[3].clubName;
			document.getElementById("fiveclubname3").innerHTML = date[3].clubName;
			document.getElementById("fiveclubtenet3").innerHTML = '宗旨：'+date[3].clubTenet+'<br>'+'简介:'+date[3].clubIntroduction;
		})
		$.getJSON("SelectAllNoticeToIndex",function (date){
			$.getJSON("AllActivityToIndex",function (date2){
				console.log(date)
				console.log(date2)
				for (var i = 0;i <= date.length;i++){
					var datetime = date[i].noticeDate;
					var datetime2 = date2[i].startDate;
					//格式化时间
					var formatdatetime = formatDate(datetime);
					var formatdatetime2 = formatDate(datetime2);
					document.getElementById("indexnotice"+i).innerText = date[i].clubName+formatdatetime+':'+date[i].noticeContent
					document.getElementById("indexnotice"+i).href += date[i].clubName;
					document.getElementById("indexactivity"+i).innerText = date2[i].club+formatdatetime2+date2[i].activityName+':'+date2[i].activityContent
					document.getElementById("indexactivity"+i).href += date2[i].activityName;
				}
			})

		})

	}
</script>
</html>