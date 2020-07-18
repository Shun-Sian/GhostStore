$(document).ready(bindEventListeners)
function bindEventListeners() {
	const authToken = window.localStorage.getItem("authToken")
	if(authToken != null) {
		logWithAuthToken(authToken)
	}
	const pageSwitcher = new PageSwitcher(document.getElementById("pageWrapper"))
	window.pageSwitcher = pageSwitcher
	pageSwitcher.replacePage("./static/fragments/mainPageFragment.html")
	bindLoginButton()
	bindRegisterButton()
	
	
}
function replaceAuth(){
	if(!window.user){
		$(".auth-nav").load("./static/fragments/loggedAuth.html")
		setTimeout(function() {
			bindLoginButton()
			bindRegisterButton()
		},500)
	}else{
		pageSwitcher.replacePage("./static/fragments/mainPageFragment.html")
		$(".auth-nav").load("./static/fragments/logout.html")
		setTimeout(function() {
			bindLogoutButton()
		},500)
	}
}
function logWithAuthToken(token){
	fetch(`http://localhost:8080/testproject1/login?token=true`, {
		method:"POST",
		body:JSON.stringify({
			token,
		}),
		headers:{
			"Content-Type":"application/json"
		}
	})
	.then(res => res.json())
	.then(res => {
		window.user = res
		replaceAuth()
	})
}
function bindLoginButton(){
	document.getElementById("loginLink").addEventListener("click",function() {
		pageSwitcher.replacePage("./static/login.html")
		setTimeout(() => {
			document.getElementById("loginForm").addEventListener("submit", e => {
				e.preventDefault();
			})
			document.getElementById("submitLogin").addEventListener("click",e => {
				e.preventDefault();
				const username = document.getElementById("username").value;
				const password = document.getElementById("password").value;
				
				fetch("http://localhost:8080/testproject1/login",{
					method:"POST",
					body:JSON.stringify({
						username:username,
						password:password
					}),
					headers:{
						"Content-Type":"application/json"
					}
				})
				.then(res => res.json())
				.then(res => {
					if(res.key == "error") {
						alert(res.body)
					}else if(res.key == "token") {
						window.localStorage.setItem("authToken",res.body)
						logWithAuthToken(res.body)
					}
				})
			})		
		},500)
		
		
	});
}
function bindRegisterButton() {
	document.getElementById("registerLink").addEventListener("click",() => pageSwitcher.replacePage("./static/registerPage.html"));
}
function bindLogoutButton() {
	document.getElementById("logout").addEventListener("click",() => {
		window.localStorage.removeItem("authToken")
		window.user = null
		replaceAuth()
	})
}