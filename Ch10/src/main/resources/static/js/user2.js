$(function(){
				
				//User2
				$('#btnUser2s').click(function(){
					
					$.ajax({
						type: 'GET',
						url: '/Ch10/user2',
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser2').click(function(){
					
					$.ajax({
						type: 'GET',
						url: '/Ch10/user2/a102',//user1옆의 A102가 ID파라미터
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser2Register').click(function(){
					
					const jsonData={
						ID:'s101',
						NAME:'김길두',
						HP:'010-7777-8888',
						AGE: 22
					};
					
					$.ajax({
						type: 'POST',
						url: '/Ch10/user2',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
				
				$('#btnUser2Modify').click(function(){

						const jsonData={
						ID:'s101',
						NAME:'김길미',
						HP:'010-8888-9999',
						AGE: 32
					};
					
					$.ajax({
						type: 'PUT',
						url: '/Ch10/user2',
						data: jsonData,
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
					
				});
				
				
				$('#btnUser2Delete').click(function(){
					
					$.ajax({
						type: 'DELETE',
						url: '/Ch10/user2/s101',
						dataType:'json',
						success: function(data){
							console.log(data);
						}
					});
					
				});
				
			});