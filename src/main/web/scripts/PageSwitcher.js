
class PageSwitcher {

	constructor(basePage) {
		this.basePage = basePage;
	}

	async replacePage(nextPage) {
		await $(this.basePage).load(nextPage);
//		const pageElement = $load(nextPage);
//		this.basePage.innerHTML = pageElement.innerHTML;
	}
}