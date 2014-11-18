Ako si nastaviť vývojové prostredie pre leJOS
=================================
(*Poznámka:* Chcel som vám spraviť video, ale môj internet sa rozhodol, že si
dnes nestiahnem ani len Eclipse, nie to ešte nahrať nejaké video)

Inštalácia potrebných programov
---------------------------------
V prvom rade je potrebné stiahnuť si Eclipse [odtiaľto](http://eclipse.org/downloads/?osType=win32&release=undefined).
Vyberte hneď tú prvú možnosť (Eclipse IDE for Java Developers), prípadne 
zmeňte platformu. Stiahne sa vám .zip súbor, ktorý môžete rozbaliť viac-menej
kam chcete, ideálne niekam do svojej domovskej zložky, kam budete
rozbaľovať aj leJOS SDK.
Myslím, že je nutné inštalovať aj JDK (fakt si nie som istý...) [odtiaľto](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html).

Nasleduje inštalácia samotného leJOSu. Windowsáci si ho stiahnu
[odtiaľto](http://sourceforge.net/projects/lejos/files/lejos-EV3/0.8.1-beta/leJOS_EV3_0.8.1-beta_win32.zip/download)
, Unixáci [odtiaľto](http://sourceforge.net/projects/lejos/files/lejos-EV3/0.8.1-beta/leJOS_EV3_0.8.1-beta_win32.zip/download).
Zložku, ktorú súbor obsahuje rozbaľte kde len chcete, ale tak, aby ste to potom
aj našli.

Konfigurácia Eclipsu
----------------------------------
Po tom, čo ste si na počítač stiahli kopu bordelu máte možno aj právo si
myslieť, že všetko je hotové. Omyl. Zábavná časť sa začína až teraz. Otvorte
Eclipse (áno, môže to chvíľku trvať), odsúhlaste (alebo zmeňte, je to na vás)
umiestnenie workspaceu, teda miesta, kde sa budú ukladať všetky vaše projekty a
ste dnu.

Prvý krok je inštalácia leJOS pluginu do Eclipse. Otvorte `Help->Install New
Software...` (až budete čakať, kým sa ten plugin nainštaluje, pochopíte, prečo
tam dali tri bodky) a vedľa políčka `Work with:` stlačte `Add`. Zdroj nazvite
pokojne akokoľvek (napríklad leJOS) a ako lokáciu použite 
`http://lejos.sourceforge.net/tools/eclipse/plugin/ev3`. Zaškrtnite políčko
vedľa `leJOS EV3 Support` a dokončite inštaláciu.

Po reštarte Eclipsu sa vám vo `Window->Preferences` objaví naľavo možnosť `leJOS
EV3`. Jediné čo v nej musíte nastaviť je, že v `EV3_HOME` zvolíte zložku, ktorú
ste vybalili z archívu obsahujúceho leJOS. V tomto bode je Eclipse
nakonfigurovaná a môžete vytvoriť nový projekt.

Vytvorenie nového projektu
------------------------------------
Nový projekt pre EV3 sa vytvára pre Eclipse štandardným spôsobom, a to cez
`File->New->Project->LeJOS EV3->LeJOS EV3 Project` a vyplnením názvu na ďalšej
obrazovke. 

Potom, čo sa vám projekt objaví v ľavom paneli však prichádza chyták. JDK,
ktoré používame je totiž novšie ako to, ktoré je v leJOSe. To spôsouje, že ak
v ňom vyprodukujete nejaký Javový bytekód, EV3 kocka vám ten program zhodí s
výnimkou. Preto je potrebné kliknúť na názov projektu pravým a v
`Properties->Java Build Path->Libraries` zvoliť `JRE System Library` (alebo
podobné, je možné, že u mňa sa volá trošku inak), kliknúť na `Edit` a v
`Execution Environment` zvoliť to, ktoré má v názve `1.7`.

Tieto kroky je potrebné zopakovať pre každý projekt.

Nastavenie driverov pre EV3
------------------------------------
Kocka, na ktorej beží leJOS nebude bežným Windowsom rozoznaná, inštalácia
driverov zlyhá. Preto môžete použiť 
[tento](http://developer.toradex.com/knowledge-base/how-to-install-microsoft-rndis-driver-for-windows-7)
návod na ich sprevádzkovanie, len ten Mindstorm nebude medzi Ostatnými
zariadeniami ako `RNDIS Kit`, ale bude mať mierne odlišný názov.

Ak si chcete spustiť správcu zariadení ako admin (čo budete musieť), v Štarte
si dajte vyhľadávať `compmgmt.msc` a po pravom kliknutí zvoľte `Spustiť ako
Administrátor`.