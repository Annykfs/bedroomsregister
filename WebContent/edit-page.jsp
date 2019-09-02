<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.*" import="java.util.List"%>
<%
	int number = Integer.parseInt(request.getParameter("number"));
	DAO dao = new DAO();
	List<Bedroom> uniqueBedr = dao.validateNum(number);

	if (uniqueBedr.isEmpty()) {
		response.sendRedirect("index.jsp");
	} else { //ABRINDO ELSE E FECHANDO LÁ EMBAIXO
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style>
#box-top-first {
	border-bottom: 1px solid #ccc;
	margin-bottom: 0;
	margin-top: 5%;
	padding-top: 6px;
}

#box-top-second {
	border-bottom: 1px solid #ccc;
	margin-bottom: 0;
	padding-bottom: 0px;
}

#form-box {
	height: 27%;
	width: 80%;
	margin-top: 30px;
	margin-bottom: -10px;
}

#namelist {
	font-size: 35px;
	font-weight: bold;
}

#inputlist {
	width: 350px;
}

#btn-list {
	margin-right: 5px;
	width: 180px;
}

.input-top-main {
	text-align: center;
	padding: 0;
	line-height: 25px;
	height: 26px;
	float: right;
	margin-right: 15px;
	margin-bottom: 0;
}

input {
	width: 300px;
}

.thtop {
	font-size: 140%;
}

#listsection {
	/*background-color: #ccff00;*/
	
}

#btn-submit {
	height: 40px;
	width: 267px;
	margin-left: 1%;
	margin-top: 3.5%;
}

li {
	list-style-type: none;
}

body {
	font-family: Tahoma, Geneva, sans-serif;
}
</style>
</head>
<body>

	<article class="container">
		<div class="row-fluid" id="box-top-first">

			<div class="input-top-main">
				<ul>
					<li class="input-group"></li>
					<li>
						<div class="input-group">
							<button type="button" class="btn btn-outline-success"
								id="btn-list" onclick="window.location.href = 'index.jsp';">See
								list!</button>
							<input disabled type="text" class="form-control" id="inputlist"
								placeholder="select the bedroom's number"
								aria-label="Recipient's username with two button addons"
								aria-describedby="button-addon4">
							<div class="input-group-append" id="button-addon4">
								<button disabled
									class="btn btn-outline-secondary btn-outline-info"
									id="input-edit" type="button">Edit now!</button>
								<button disabled
									class="btn btn-outline-secondary btn-outline-danger"
									id="input-delete" type="button">Delete!</button>
							</div>
						</div>
					</li>
				</ul>
			</div>

			<h1 class="settings-header" id="namelist">Edit a bedroom</h1>

		</div>


		<div class="container row-fluid settings-body" id="box-top-second">
			<div class="container" id="form-box">
				<form class="needs-validation" method="post" action="Update"
					novalidate>
					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label>Owner</label> <input type="text" class="form-control"
								name="owner" value=<%=uniqueBedr.get(0).getOwner()%>
								required="required" id="owner" onchange="validateBut();">

						</div>
						<div class="col-md-4 mb-3">
							<label>Area</label> <input type="text" class="form-control"
								name="area" value=<%=uniqueBedr.get(0).getArea()%>
								placeholder="" required="required" id="area"
								onchange="validateBut();">
						</div>

						<div class="col-md-4 mb-3">
							<label>Number</label>
							<div class="input-group">
								<input readonly="readonly" type="text" class="form-control"
									name="number" placeholder=""
									aria-describedby="inputGroupPrepend" required="required"
									id="number" onchange="validateBut();" value=<%=number%>>
							</div>
						</div>

					</div>

					<div class="form-row">
						<div class="col-md-4 mb-3">
							<label>Wall's color</label>
							<div class="input-group">
								<input type="text" class="form-control" name="color"
									value=<%=uniqueBedr.get(0).getColor()%> placeholder=""
									aria-describedby="inputGroupPrepend" required="required"
									id="color" onchange="validateBut();">
							</div>
						</div>
						<div class="col-md-4 mb-3">
							<label>Suite</label> <select class="custom-select  mb-3"
								name="suite" id="suite" onchange="validateBut();">
								<option value="undefined">Open this select menu</option>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</div>

						<div style="display: none;" id="auxSuite">
							<%=uniqueBedr.get(0).getSuite()%>
						</div>

						<button class="btn btn-primary" id="btn-submit" type="submit">Update
							now</button>
				</form>

			</div>
			<div class="settings-section" id="listsection"></div>
		</div>
		</div>
	</article>

</body>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<
<script>
	$(document).ready(function() {
		if (document.querySelector("#auxSuite").innerText == " no ") {
			document.querySelector("#suite").value = "no";
		} else if (document.querySelector("#auxSuite").innerText == " yes ") {
			document.querySelector("#suite").value = "yes";
		}

	});

	function validateBut() {
		var owner = document.querySelector("#owner").value;
		var area = document.querySelector("#area").value;
		var number = document.querySelector("#number").value;
		var color = document.querySelector("#color").value;
		var suite = document.querySelector("#suite").value;

		if (owner != "" && area != "" && number != "" && color != ""
				&& suite != "undefined") {

			document.querySelector("#btn-submit").removeAttribute("disabled");
		} else {
			document.querySelector("#btn-submit").disabled = true;
		}

	}
</script>
</html>
<%
	} //FECHANDO, E ABRINDO LA EM CIMA
%>