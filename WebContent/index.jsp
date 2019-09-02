<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="model.*" import="java.util.List"%>

<%
	String redirectURL = "form.jsp";
	DAO dao = new DAO();
	List<Bedroom> bedList = dao.accessData();
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

#namelist {
	font-size: 35px;
	font-weight: bold;
}

#inputlist {
	width: 350px;
}

#input-new {
	margin-right: 5px;
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
								id="input-new" onclick="window.location.href = 'form.jsp'">
								New!</button>

							<input type="text" class="form-control" id="inputlist"
								placeholder="select the bedroom's number"
								aria-label="Recipient's username with two button addons"
								aria-describedby="button-addon4">
							<div class="input-group-append" id="button-addon4">
								<button class="btn btn-outline-secondary btn-outline-info"
									id="input-edit" type="button" onclick="getInput();">Edit
									now!</button>
								<button class="btn btn-outline-secondary btn-outline-danger"
									id="input-delete" type="button" onclick="getInputToDrop();">Delete!</button>
							</div>
						</div>
					</li>
				</ul>
			</div>

			<h1 class="settings-header" id="namelist">Bedroom's list</h1>

		</div>


		<div class="container row-fluid settings-body" id="box-top-second">
			<div class="settings-section" id="listsection">
				<table class="table table-striped">
					<thead>
						<tr>
							<th class="thtop" scope="col">Owner</th>
							<th class="thtop" scope="col">Area</th>
							<th class="thtop" scope="col">Number</th>
							<th class="thtop" scope="col">Wall's Color</th>
							<th class="thtop" scope="col">Suite</th>
						</tr>
					</thead>
					<tbody>
						<%
							for (int i = 0; i < bedList.size(); i++) {
						%>
						<tr>
							<th scope="row"><%=bedList.get(i).getOwner()%></th>
							<td><%=bedList.get(i).getArea()%>m<sup>2</sup></td>
							<td><%=bedList.get(i).getNumber()%></td>
							<td><%=bedList.get(i).getColor()%></td>
							<td><%=bedList.get(i).getSuite()%></td>
						</tr>
						<%
							} /// close for
						%>
					</tbody>
				</table>
			</div>
		</div>
		</div>
	</article>
</body>

<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>

<script>
	function getInput() {
		var numberEdit = document.querySelector("#inputlist").value;
		if (numberEdit != "") {
			window.location.href = 'edit-page.jsp?number=' + numberEdit;
		}
	}

	function getInputToDrop() {
		var numberDrop = document.querySelector("#inputlist").value;
		if (numberDrop != "") {
			window.location.href = 'DropData?number=' + numberDrop;
		}
	}

	$('#inputlist').on(
			'keypress',
			function(event) {
				var regex = new RegExp("(^[0-9])");
				var key = String.fromCharCode(!event.charCode ? event.which
						: event.charCode);
				if (!regex.test(key)) {
					event.preventDefault();
					return false;
				}
			});
</script>

</html>


