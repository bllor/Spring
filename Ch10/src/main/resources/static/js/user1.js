$(function(){
				
				//User1
				$('#btnUser1s').click(function(){
					
					$.ajax({
						type: 'GET',
						url: '/Ch10/user1',
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser1').click(function(){
					
					$.ajax({
						type: 'GET',
						url: '/Ch10/user1/A102',//user1옆의 A102가 ID파라미터
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser1Register').click(function(){
					
					const jsonData={
						ID:'s105',
						NAME:'김길서',
						HP:'010-7777-8888',
						AGE: 22
					};
					
					$.ajax({
						type: 'POST',
						url: '/Ch10/user1',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser1Modify').click(function(){

						const jsonData={
						ID:'s105',
						NAME:'이길남',
						HP:'010-8888-9999',
						AGE: 32
					};
					
					$.ajax({
						type: 'PUT',
						url: '/Ch10/user1',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
					
				});
				
				
				$('#btnUser1Delete').click(function(){
					
					$.ajax({
						type: 'DELETE',
						url: '/Ch10/user1/s101',
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
			});