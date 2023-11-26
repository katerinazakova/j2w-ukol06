[#ftl]
[@c.page]
    <div class="seznam">
        [#list seznamOsob]
            [#items as osoba]
                <a href="/${osoba.id}">
                    <div class="vizitka">
                        <div class="jmeno">${osoba.celeJmeno}</div>
                        <div class="firma">${osoba.firma}</div>
                        <div class="udaje">
                            <div class="adresa">
                                <div>${osoba.ulice}</div>
                                <div><span>${osoba.psc}</span> <span>${osoba.obec}</span></div>
                            </div>
                            <div class="kontakty">
                                <div><i class="las la-at"></i> <span>${osoba.email!}</span></div>
                                <div><i class="las la-phone-alt"></i> <span>${osoba.telefon!}</span></div>
                                <div><i class="las la-globe"></i> <span>${osoba.web!}</span></div>
                            </div>
                        </div>
                    </div>
                </a>
            [/#items]
        [/#list]
        <a href="/nova">
            <div class="vizitka vizitka--nova">
                <svg width="100" height="100">
                    <rect width="20" height="100" x="40" y="0" fill="white"/>
                    <rect width="100" height="20" x="0" y="40" fill="white"/>
                </svg>
            </div>
        </a>
    </div>
[/@c.page]
