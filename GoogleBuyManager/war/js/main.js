var order_counter = 0;
var show_alert_delay_time = 4000;
var customers;
var id_customer = "cust";
var id_product = "prod";
var auth;

$(document).ready(
	
    function () {
    	
    	/** initial some components when the page is loaded */
    	// hide alert block
    	$("div#msg").hide();
    	$("div#info").hide();
    	
    	// get Auth in the cookie
    	
    	/** loading some initial data from the remote server */
    	customers = loadCustomers();
    	
        $("button#add_order").click( 
        		
            function ()
            {
                addOrder();
                
                if(null !== customers)
                {
                	$(this).removeAttr("disabled");
//                	attachCustomers();
                }
                else
                {
                	$(this).attr("disabled", true);
                }
            }
        );
        
        $("#order_list").on("click", "button#btn_product",
            function()
            {
                var row = addRowPair();
                $(this).closest("tbody").append(row);
                $(this).closest("tr").remove();
            }
        );
    }
);

function getAuth()
{
	return $.cookie("auth");
}

function showAlert(message)
{
	$("div#msg").slideDown("slow", function(){$("div#msg").html(message);}).delay(show_alert_delay_time).slideUp("slow");
}

function showInfo(message)
{
	$("div#info").slideDown("slow", function(){$("div#info").html(message);}).delay(show_alert_delay_time).slideUp("slow");
}

function loadCustomers()
{
	$.ajax(
	    	{
	    		type: "GET",
	            url: "/customer?opt=1",
	            dataType: "json",
	            success: function(data)
	            {
	            	showInfo("已经成功从服务器上获取所有客户信息");
	            	return data;
	            },
	            error: function(e)
	            {
	            	showAlert("错误：无法从服务器上获取客户信息");
	            	return null;
	            }
	    	}
	    );
}

function addOrder()
{
    var result = "<div id='order'>";
    result += getOrderTitle(id_customer);
    result += getOrderTable(id_product);
    result += "</div>";
    $("div#order_list").append(result);
}

function getOrderTitle(id)
{
    var result = "";
    result += "<div id='order'>";
    result += "<div id='order_title' class='row'>";
    result += "<div class='col-sm-3'>";
    result += getDropDown("选择客户", id);
    result += "</div>";
    result += "<div class='col-sm-6'>";
    result += "<lable />";
    result += "</div>";
    result += "<div class='col-sm-3'>总额: ";
    result += "</div>";
    result += "</div>";
    result += "</div>";
    result += "<br />";
    return result;   
}

function getOrderTable()
{
    var result = "";
    result += "<table id='orderTable' class='table table-striped table-hover table-condensed'>";
    result += getTableHeader();
    result += getTableBody();
    result += "</table>";
    return result;
}

function getTableHeader()
{
    var result = "";
    result += "<thead>"
    result += "<tr><td>商品</td><td>单价</td><td>总价</td></tr>"
    result += "</thead>";
    return result;
}

function getTableBody()
{
    var result = "";
    result += "<tbody>";
    result += addRowPair();
    result += "</tbody>";
    return result;
}

function addRowPair()
{
    var result = "";
    result += addRow("Gong Wei", true, false);
    result += addRow("Gong Wei", false, true);
    return result;
}

function addRow(order_number, show, is_button)
{
    var result = "";
    result += ("<tr>");
    if( is_button )
    {
        result += ("<td>" +  getPrimaryButton("添加商品") + "</td>");
    }
    else
    {
        result += ("<td>" + getDropDown("商品列表") + "</td>");
    }
    
    if (show) 
    {
        result += ("<td>" + getInputLine() + "</td>");
        result += ("<td>" + getInputLine() + "</td>");
    } 
    else 
    {
        result += ("<td><label></label></td>");
        result += ("<td><label></label></td>");
    }
    result += "</tr>";
    return result;
}

function getInputLine()
{
    var result = "";
    result += "<div class='form-group'>";
    result += "<input type='text' class='form-control' id='input' disabled>";
    result += "</div>";
    return result;
}

function getDropDown(name, id) {
    var result = "<div id='" + id + "' class='dropdown'><button class='btn btn-default dropdown-toggle' type='button' id='menu1' data-toggle='dropdown'>" + name + "<span class='caret'></span></button>";
    result += "<ul class='dropdown-menu' role='menu' aria-labelledby='menu1'>";
    result += "</ul></div>";
    return result;
//    			result += ("<li role='presentation'><a role='menuitem' tabindex='-1' href='#'>hello</a></li>");
}

function getPrimaryButton(button_name) {
    return "<button id='btn_product' type='button' class='btn btn-primary'>" + button_name + "</button>";
}