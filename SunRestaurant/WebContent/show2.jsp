<%@ page language="java"
	import="java.util.*,edu.cugb.xg.javaee.dao.*,edu.cugb.xg.javaee.bean.*"
	pageEncoding="GBK"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<HTML>
	<HEAD>
		<TITLE>��ѧ�һ����϶���ϵͳ</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<link rel="stylesheet" href="./css/styles.css" type="text/css" />

		<SCRIPT language=JavaScript type=text/JavaScript>
<!--

-->
</SCRIPT>

	</HEAD>
	<BODY leftMargin=0 topMargin=0 marginheight="0" marginwidth="0">
		<jsp:useBean id="loginuser" class="edu.cugb.xg.javaee.bean.Users"
			scope="session"></jsp:useBean>

		<table cellSpacing=0 cellPadding=0 width=776 align=center border=0>
			<tr>
				<td width="220" rowspan="3">
				</td>
				<td width="556" height="36">
				</td>
			</tr>
			<tr>
				<TD
					style="FONT-SIZE: 24pt; FILTER: blur(add =                           1, direction =                           120, strength =                           5); WIDTH: 100%; COLOR: #000000; FONT-FAMILY: arial; POSITION: relative"
					noWrap>
					<B><span class="STYLE1">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;XXXX</span>���϶���ϵͳ</B>
				</TD>
			</tr>
			<tr>
				<td>
				</td>
			</tr>
		</table>

		<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
			<TBODY>
				<TR>
					<TD background="images/001.gif" height=42>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD width=0 height=20></TD>
									<TD align=center>
										<FONT style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
											href="#" target=_self><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">��վ��ҳ</FONT> </A><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
											href="#" target=_self><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">��������</FONT> </A><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
											href="#" target=_self><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">���Ͱ���</FONT> </A><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
											href="#" target=_self><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">���϶���</FONT> </A><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT><A
											href="#" target=_self><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">�ͷ�����</FONT> </A><FONT
											style="FONT-SIZE: 13px; COLOR: #000000">&nbsp;|&nbsp;</FONT>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
			<TBODY>
				<TR vAlign=top>
					<TD width=181 background="images/002.gif">
						<TABLE cellSpacing=0 cellPadding=0 width=181 border=0>
							<TBODY>
								<TR>
									<TD>
										<IMG height=234 src="images/left_top.jpg" width=181>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD align=middle height=30>
										<FONT color=#000000> <SCRIPT language=javascript
												src="images/DateTime2.js"></SCRIPT> <SCRIPT
												language=javascript>tick('cn');</SCRIPT> </FONT>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD>
									</TD>
								</TR>
								<TR>
									<TD background="images/003.gif" height=4></TD>
								</TR>
								<TR>
									<TD>
									</TD>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD>
									</TD>
								</TR>
								<TR>
									<TD background="images/003.gif" height=4></TD>
								</TR>
								<TR>
									<TD align=middle>
										<TABLE cellSpacing=0 cellPadding=0 width="94%" border=0>
											<TBODY>
												<TR>
													<TD>
													</TD>
												</TR>
											</TBODY>
										</TABLE>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
					<TD>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD>
										<IMG height=72 src="images/001.jpg" width=595>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD width="90%">
										<div class='cnt'>
											<marquee style="FONT-SIZE: 13px; COLOR: #0000FF"
												scrollamount='5' direction='left'>
												<IMG height=15 src="images/tp009.gif" width=15>
												��ӭ${sessionScope.loginuser.username}ʹ����ѧ�һ����϶���ϵͳ��ף���ò���죡
											</marquee>
										</div>
										&nbsp;&nbsp;
									</TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD align=right background="images/004.gif" height=19></TD>
								</TR>
							</TBODY>
						</TABLE>
						<TABLE cellSpacing=1 cellPadding=1 width="100%" align=center
							border=0>
							<TBODY>
								<TR bgColor=#dadada >
									<TD width="100%" align="right" colspan="2" >
										<a href="viewcart"> <img src="images/lcart_cn.gif" border=0
												width="97" height="30"> </a>
									</TD>
								</TR>
								<c:forEach var="currentdish" items="${requestScope.dishlist}" varStatus="status" >								
								<c:if test="${status.index%2==0}">
								<tr>
								</c:if>
									<td>
										
											<TABLE height="100%" cellSpacing=1 cellPadding=2 border=0>
												<TBODY>
													<TR>
														<TD vAlign=top width=90 height=90>
															<A href=showdetail?dishid=${currentdish.dishid} target=_blank><IMG height=80 alt=���ͼƬ�鿴����
																	src="images/${currentdish.img}" width=80 border=0> </A>
														</TD>
														<TD vAlign=top>
															<TABLE cellSpacing=1 cellPadding=0 width="100%"
																align=center border=0>
																<TBODY>
																	<TR>
																		<TD>
																			<A href=# target=_blank><STRONG>${currentdish.dishname}</STRONG> </A>
																		</TD>
																	</TR>
																	<TR>
																		<TD height=21>
																			<FONT color=#ff0000>�ּۣ������${currentdish.price}Ԫ</FONT>
																			<BR>
																			${currentdish.dishdesc}
																		</TD>
																	</TR>
																</TBODY>
															</TABLE>
														</TD>
													</TR>
												</TBODY>
											</TABLE>
										
									</td>
								<c:if test="${status.index%2!=0}">
								</tr>
								</c:if>
								</c:forEach>
								<tr>
									<td  height="2">
										<div align="left">
											<font color="#000000">&nbsp;��&nbsp${param.totalpages}&nbspҳ</font>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											<font color="#000000">��ǰ��</font>&nbsp
											<font color="#000000">${param.pageNO}</font>&nbsp
											<font color="#000000">ҳ</font>
										</div>
									</td>
									<td  >
										<div align="right">
											<a name="btnTopPage"  id="btnTopPage" href="loginControl?actiontype=pagelist&pageNO=1" title="��ҳ">|&lt;&lt; </a>&nbsp;
											<a name="btnPreviousPage"  id="btnPreviousPage" href="loginControl?actiontype=pagelist&pageNO=${requestScope.pageModel.prevPageNO}" title="��ҳ"> &lt;  </a>&nbsp;
											<a name="btnNextPage"  id="btnNextPage" href="loginControl?actiontype=pagelist&pageNO=${requestScope.pageModel.nextPageNO}" title="��ҳ">  &gt; </a>&nbsp;
											<a name="btnBottomPage"  id="btnBottomPage" href="loginControl?actiontype=pagelist&pageNO=${requestScope.pageModel.bottomPageNO}" title="βҳ"> &gt;&gt;|</a>
											
										</div>
									</td>
								</tr>
							</TBODY>
						</TABLE>
					</td>
				</TR>

			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
			<TBODY>
				<TR>
					<TD background="images/005.gif" height=8>&nbsp;</TD>
				</TR>
			</TBODY>
		</TABLE>
		<TABLE cellSpacing=0 cellPadding=0 width=776 align=center border=0>
			<TBODY>
				<TR>
					<TD bgColor=#eeeeee>
						<TABLE cellSpacing=0 cellPadding=0 width="100%" border=0>
							<TBODY>
								<TR>
									<TD align=middle>
										<BR>
										<P align=center>
											<FONT color=#000000>Copyright &copy;
												2010&nbsp;&nbsp;&nbsp;&nbsp; XXXX���޹�˾����</FONT>
										</P>
										<P align=center>
										</P>
										<BR>
										<BR>
									</TD>
								</TR>
							</TBODY>
						</TABLE>
					</TD>
				</TR>
			</TBODY>
		</TABLE>
	</BODY>
</HTML>
