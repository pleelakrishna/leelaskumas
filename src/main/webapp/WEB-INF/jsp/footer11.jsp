<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!-- Footer starts here -->

	</div><!-- /.main-container -->
	<div class="footer">
		<div class="footer-inner">
			<div class="footer-content">
				<span class="bigger-120">
					<span class="blue bolder">Kumar Pumps</span> &copy; 2017
				</span>
			</div>
		</div>
	</div>

	<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
		<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
	</a>
	
	<script type="text/javascript">
	$('#designation').blur(function() {
		var role=$(this).val();
		if(role ===  '1')
			$('#reportto').prop('disabled', true);
		else
			$('#reportto').prop('disabled', false);
		
		
	});
		
	
	</script>
	
	<!-- basic scripts -->
	<script src="${pageContext.request.contextPath}/js/customValidation.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>

	<!-- page specific plugin scripts -->
	<!--[if lte IE 8]>
		<script src="assets/js/excanvas.min.js"></script>
	<![endif]-->
	<script src="${pageContext.request.contextPath}/assets/js/jquery-ui.custom.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.ui.touch-punch.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.easypiechart.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.sparkline.index.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.pie.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.flot.resize.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/jquery.blockUI.min.js"></script>
	

	<!-- ace scripts -->
	<script src="${pageContext.request.contextPath}/assets/js/ace-elements.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/ace.min.js"></script>
	
</body>
</html>
<!-- Footer ends here -->