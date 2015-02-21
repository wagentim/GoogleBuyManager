var customers;

$(document).ready(
		
		function()
		{
			refreshCustomersList();
			
			$(".back").click(
				function()
				{
					window.history.back();
				}
			);
			
			$("a.new").click(
				function()
				{
					reset_form();
				}
			);
			
			$(".list-group").on("click", ".item", function(){
				var id = $(this).attr("uid");
				assignValues(id);
			});
			
			$(".myform").submit(function(e){
				var postData = $(this).serializeArray();
			    var formURL = $(this).attr("action");
			    $.ajax(
			    {
			        url : formURL,
			        type: "POST",
			        data : postData,
			        success:function(data, textStatus, jqXHR) 
			        {
			        	refreshCustomersList();
			        },
			        error: function(jqXHR, textStatus, errorThrown) 
			        {
			            alert("error");    
			        }
			    });
			    e.preventDefault();
			    e.unbind();
			});
			
			$(".save").click(function(){
				$(".myform").submit();
			});
		}
);

function refreshCustomersList()
{
	removeCustomers();
	loadCustomers();
	addCustomers();
}

function removeCustomers()
{
	$(".list-group").empty();
}

function loadCustomers()
{
	$.ajax(
	    	{
	    		type: "GET",
	            url: "/customer?opt=1",
	            dataType: "json",
	            async: false,
	            success: function(data)
	            {
	            	customers = data;
	            },
	            error: function(e)
	            {
	            	customers = null;
	            }
	    	}
	    );
}

function reset_form()
{
	$(":input", ".myform").val("");
	$("input#uid").val("0");
}

function addCustomers()
{
	var result = "<a href='#' class='list-group-item active new' style='text-align: center'>+ 新建客户</a>";
	var length = customers.length;
	for(var i = 0; i < length; i++)
	{
		result += "<a href='#' class='list-group-item item' style='text-align: center' uid="+ customers[i].id +">" + customers[i].lastName + " " + customers[i].firstName + "</a>";
	}
	
	$(".list-group").append(result);
}

function assignValues(id)
{
	var customer;
	for(var i = 0; i < customers.length; i++)
	{
		var tmp = JSON.stringify(customers[i].id);
		if( id == tmp )
		{
			customer = customers[i];
			break;
		}
	}
	$("#uid").val(customer.id);
	$("#alias").val(customer.alias);
	$("#telephon").val(customer.telefon);
	$("#email").val(customer.email);
	$("#country").val(customer.country);
	$("#province").val(customer.province);
	$("#city").val(customer.city);
	$("#zipcode").val(customer.zipcode);
	$("#address").val(customer.address);
	$("#firstname").val(customer.firstName);
	$("#lastname").val(customer.lastName);
}

