/**
 * 題目：子域名访问计数
 */
/**
 * @param {string[]} cpdomains
 * @return {string[]}
 */
 var subdomainVisits = function(cpdomains) {
    let cpdDomainLIst = cpdomains.map(pair => pair.split(" ")).map(pair => {
        return [+pair[0], splitDomains(pair[1])];
    })
    let map = new Map();
    cpdDomainLIst.reduce((accu, cur) => {
        let count = cur[0];
        for(let i = 0; i < cur[1].length; i++) {
            let domain = cur[1][i];
            if(!accu.has(domain)) {
                accu.set(domain,count);
            } else {
                accu.set(domain, accu.get(domain) + count);
            }
        }
        return accu;
    }, map);
    let ans = [];
    map.forEach((key, val) => {
        ans.push(computeCountPair(key, val));
    })
    return ans;
};

// e.g. input "google.mail.com" -> ["google.mail.com, mail.com, com"]
function splitDomains(domains) {
    let result = [];
    let domainArr = domains.split(".");
    for(let i = 0; i < domainArr.length; i++) {
        result.push(domainArr.slice(i));
    }
    return result.map(i => i.join("."));
}

function computeCountPair(key, value) {
    return key + " " + value; 
}