function replacer(key, value) {
	if (value === null) {
		return undefined;
	}
	return value;
}

function fetchPromise(request) {
	let status;
	return fetch(request)
		.then(response => {
			status = response.ok;
			return response.json();
		})
		.then(json => {
			if (status) {
				return json;
			} else {
				switch (typeof json) {
					case 'object':
						if (json.code === '1000') {
							throw new Error(json.errorDataList
								.map(errorData => errorData.message)
								.join('\n')
							);
						}
						break;
					case 'string':
						throw new Error(json);

					default:
						break;
				}
			}
		});
}

const commAjax =  {
	html: function (url, params) {
		let request,
			query;
		const esc = encodeURIComponent;

		if (params) {
			query = Object.keys(params)
				.map(k => `${esc(k)}=${esc(params[k])}`)
				.join('&');

			url += '?' + query;
		}

		request = new Request(url, {
			method: 'get',
			credentials: 'same-origin',
			headers: new Headers({
				'Content-Type': 'application/html',
				'X-Requested-With': 'XMLHttpRequest'
			})
		});

		return fetchPromise(request);
	},

	get: function (url, params) {
		let request,
			query;
		const esc = encodeURIComponent;

		if (params) {
			query = Object.keys(params)
				.map(k => `${esc(k)}=${esc(params[k])}`)
				.join('&');

			url += '?' + query;
		}

		request = new Request(url, {
			method: 'get',
			credentials: 'same-origin',
			headers: new Headers({
				'Content-Type': 'application/json',
				'X-Requested-With': 'XMLHttpRequest'
			})
		});

		return fetchPromise(request);
	},

	post: function (url, params) {
		const request = new Request(url, {
			method: 'post',
			credentials: 'same-origin',
			headers: new Headers({
				'Content-Type': 'application/json',
				'X-Requested-With': 'XMLHttpRequest'
			}),
			body: JSON.stringify(params, replacer)
		});

		return fetchPromise(request);
	},

	put: function (url, params) {
		const request = new Request(url, {
			method: 'put',
			credentials: 'same-origin',
			headers: new Headers({
				'Content-Type': 'application/json',
				'X-Requested-With': 'XMLHttpRequest'
			}),
			body: JSON.stringify(params, replacer)
		});

		return fetchPromise(request);
	},

	delete: function (url, params) {
		const request = new Request(url, {
			method: 'delete',
			credentials: 'same-origin',
			headers: new Headers({
				'Content-Type': 'application/json',
				'X-Requested-With': 'XMLHttpRequest'
			}),
			body: JSON.stringify(params, replacer)
		});

		return fetchPromise(request);
	},

	postMultipart: function (url, params) {
		const request = new Request(url, {
			method: 'post',
			headers: new Headers({
				'X-Requested-With': 'XMLHttpRequest'
			}),
			credentials: 'same-origin',
			body: params
		});

		return fetchPromise(request);
	},

	putMultipart: function (url, params) {
		const request = new Request(url, {
			method: 'put',
			headers: new Headers({
				'X-Requested-With': 'XMLHttpRequest'
			}),
			credentials: 'same-origin',
			body: params
		});
		return fetchPromise(request);
	}
};