<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String message=(String) session.getAttribute("Message");
String ID=(String) session.getAttribute("ID");
//if(message!=null){
//out.print(message+ID);
if (message != null && ID != null) {
%>
    <!-- Display alert -->
     <div class="alert">
        <span><%= message+" "+ ID %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>
<%
    // Remove session attributes after displaying the alert
    session.removeAttribute("Message");
    session.removeAttribute("ID");
}
%>
<% String error=(String)request.getAttribute("Error");
if(error!=null){
%>
 <div class="alert warning">
        <span><%= error %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>


<% String searchunderwriter=(String)request.getAttribute("searchunderwriter");
if(searchunderwriter!=null){
%>
 <div class="alert warning">
        <span><%= searchunderwriter %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>


<% String Incorrectpassword=(String)request.getAttribute("Incorrectpassword");
if(Incorrectpassword!=null){
%>
 <div class="alert warning">
        <span><%= Incorrectpassword %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String Updatedsucessfully=(String)request.getAttribute("Updatedsucessfully");
if(Updatedsucessfully!=null){
%>
 <div class="alert">
        <span><%= Updatedsucessfully %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>


<% String Failed=(String)request.getAttribute("Failed");
if(Failed!=null){
%>
 <div class="alert warning">
        <span><%= Failed%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String DeleteID=(String)request.getAttribute("DeleteID");
if(DeleteID!=null){
%>
 <div class="alert">
        <span><%= DeleteID %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String Deletefail=(String)request.getAttribute("Deletefail");
if(Deletefail!=null){
%>
 <div class="alert warning">
        <span><%= Deletefail%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String CreateVehicle=(String)request.getAttribute("CreateVehicle");
if(CreateVehicle!=null){
%>
 <div class="alert">
        <span><%= CreateVehicle%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String CreateVehicleFailed=(String)request.getAttribute("CreateVehicleFailed");
if(CreateVehicleFailed!=null){
%>
 <div class="alert warning">
        <span><%= CreateVehicleFailed%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String Phone=(String)request.getAttribute("Phone");
if(Phone!=null){
%>
 <div class="alert warning">
        <span><%= Phone%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String PrmAmt=(String)request.getAttribute("PrmAmt");
if(PrmAmt!=null){
%>
 <div class="alert warning">
        <span><%= PrmAmt%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String falsepolicy=(String)request.getAttribute("falsepolicy");
if(falsepolicy!=null){
%>
 <div class="alert warning">
        <span><%= falsepolicy%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String updatedpolicy=(String)request.getAttribute("updatedpolicy");
if(updatedpolicy!=null){
%>
 <div class="alert">
        <span><%= updatedpolicy%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String Noprovision=(String)request.getAttribute("Noprovision");
if(Noprovision!=null){
%>
 <div class="alert warning">
        <span><%= Noprovision%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>


<% String Nosearch=(String)request.getAttribute("Nosearch");
if(Nosearch!=null){
%>
 <div class="alert warning">
        <span><%= Nosearch%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String Rpolicy=(String)request.getAttribute("Rpolicy");
if(Rpolicy!=null){
%>
 <div class="alert warning">
        <span><%= Rpolicy%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String FetchUnderwriter=(String)request.getAttribute("FetchUnderwriter");
if(FetchUnderwriter!=null){
%>
 <div class="alert warning">
        <span><%= FetchUnderwriter%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String ULogin=(String)request.getAttribute("ULogin");
if(ULogin!=null){
%>
 <div class="alert warning">
        <span><%= ULogin%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

 <% String id=(String)request.getAttribute("U_wrt");
 if(id!=null){
    %>
<div class="alert">
       <span><%= id%></span> 
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>

<%

}%>


 <% String ad=(String)session.getAttribute("msg");
 if(ad!=null){
    %>
<div class="alert ">
        <span><%= ad%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>

<%
session.removeAttribute("msg");
}%>
<% String Fadmin=(String)session.getAttribute("Fadmin");
if(Fadmin!=null){
%>
 <div class="alert warning">
        <span><%= "Incorrect Id or Password"%></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
session.removeAttribute("Fadmin");
}%>


<% String rajeev=(String)request.getAttribute("rajeev");
if(rajeev!=null){
%>
 <div class="alert">
        <span><%= rajeev %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>
<% String criteria=(String)request.getAttribute("criteria");
if(criteria!=null){
%>
 <div class="alert warning">
        <span><%= criteria %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>

<% String RRpolicy=(String)request.getAttribute("RRpolicy");
if(RRpolicy!=null){
%>
 <div class="alert warning">
        <span><%= RRpolicy %></span>
        <span class="close-alert" onclick="this.parentElement.style.display='none';">x</span>
    </div>


<%
}%>