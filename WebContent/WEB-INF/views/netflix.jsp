<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


</head>
<body ng-app="mainApp">
	<div style='height: 35px;' class='col-md-12'></div>
	<br />
	<br />
	<br />
	<div ng-controller="mainCtrl" class='col-md-12 '>
		<div
			class='col-md-12'>
			<h1 class='text-muted'>Movie Search</h1>
		</div>

		<div
			class='row col-md-12'>
			<div class='col-md-1'>
				<label>Title:</label>
			</div>
			<div class='col-md-4 col-sm-4 col-xs-6'>
				<input class='form-control input-sm' ng-model='title'
					placeholder='ex: Breaking Bad' />
			</div>
			<div class='col-md-2 col-sm-2 col-xs-3 '>
				<button class='btn btn-default' href='#'
					ng-click='worker.findByTitle(title)'>
					<span class='glyphicon glyphicon-upload'></span> Get Titles
				</button>
			</div>
		</div>

		<div class="col-md-2" style="height: 5px;"></div>

		<div
			class='row col-md-12'>
			<div class='col-md-1'>
				<label>Actor:</label>
			</div>
			<div class='col-md-4 col-sm-4 col-xs-6'>
				<input class='form-control input-sm' ng-model='actor'
					placeholder='ex: Nicolas Cage' />
			</div>
			<div class='col-md-2 col-sm-2 col-xs-3'>
				<button class='btn btn-default' href='#'
					ng-click='worker.findByActor(actor)'>
					<span class='glyphicon glyphicon-upload'></span> Get Titles
				</button>
			</div>
		</div>

		<div class='col-md-12' style='height: 25px;'></div>
		<div class="col-md-12">
		{{getTitleError}}
		</div>
		<div class='movie-container'>
			<div ng-repeat='value in movies' class='col-md-12 row'>
				<div class='col-md-12 col-md-offset-1'>
					<div class='col-md-4 col-sm-4 col-xs-12'>

						<img ng-src='{{value.poster}}' class='movie-poster' />

					</div>
					<div class='col-md-6 col-sm-6 col-xs-12'>
						<h1 class='text-muted'>{{value.show_title}}
							({{value.release_year}})</h1>
						<br /> <b>Netflix Rating:</b> {{value.rating}} <br /> <br />
						<div ng-if='!!value.category'>
							<b>Category:</b> {{value.category}} <br /> <br />
						</div>
						<b>Summary:</b> {{value.summary}} <br /> <br />
						<div ng-if='!value.director'></div>
						<div ng-if='!!value.director'>
							<b>Director:</b> {{value.director}} <br /> <br />
						</div>

						<b>Cast:</b> {{value.show_cast}} <br /> <br />
						<div ng-if='!!value.runtime'>
							<b>Runtime:</b> {{value.runtime}} <br /> <br />
						</div>
						<a
							href="http://www.netflix.com/WiPlayer?movieid={{value.show_id}}"
							target="_blank">
							<button type="button" class="btn btn-netflix">Watch on
								Netflix</button>
						</a> <br /> <br />

					</div>
				</div>
				<div class='col-md-12' style='height: 15px;'></div>
			</div>
		</div>

	</div>

</body>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.3/angular.min.js"></script>
<script src="js/app.js"></script>
<script src="js/factory.js"></script>
</html>