[#ftl]
[@c.page]
    <div class="detail">
        <div class="vizitka">
            <div class="jmeno">${osoba.celeJmeno}</div>
            <div class="firma">${osoba.firma}</div>
            <div class="udaje">
                <div class="adresa">
                    <div>${osoba.ulice}</div>
                    <div><span>${osoba.psc}</span> <span>${osoba.obec}</span></div>
                </div>
                <div class="kontakty">
                    [#if osoba.email??]
                    <div><i class="las la-at"></i> <span>${osoba.email}</span></div>
                    [/#if]
                    [#if osoba.telefon??]
                    <div><i class="las la-phone-alt"></i> <span>${osoba.telefon}</span></div>
                    [/#if]
                    [#if osoba.web??]
                    <div><i class="las la-globe"></i> <span>${osoba.web}</span></div>
                    [/#if]
                </div>
            </div>
        </div>

        <div class="mapa">
            <iframe style="border:none" src="https://frame.mapy.cz/?q=${osoba.celaAdresa?url}" width="100%" height="100%" frameborder="0"></iframe>
        </div>

        [@c.back /]
    </div>
[/@c.page]
