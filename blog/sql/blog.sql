SET NAMES utf8mb4;

DROP DATABASE IF EXISTS `Blog`;
CREATE DATABASE `Blog`;
USE `Blog`;

DROP TABLE IF EXISTS `Favor`;
DROP TABLE IF EXISTS `Message`;
DROP TABLE IF EXISTS `Comment`;
DROP TABLE IF EXISTS `BlogFolder`;
DROP TABLE IF EXISTS `favorfolder`;
DROP TABLE IF EXISTS `Blog`;
DROP TABLE IF EXISTS `User`;

CREATE TABLE `User`(
    `userId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `email` VARCHAR(64) NOT NULL,
    `username` VARCHAR(16) NOT NULL,
    `userImg` VARCHAR(255) DEFAULT NULL,
    `password` VARCHAR(32) DEFAULT '123456',
    `self_introduction` VARCHAR(1024) DEFAULT NULL
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `User` VALUES (1,'111@qq.com','测试一号','','123456','hello');
INSERT INTO `User` VALUES (2,'222@qq.com','测试二号','','123456','hello');
INSERT INTO `User` VALUES (3,'333@qq.com','测试三号','','123456','hello');
INSERT INTO `User` VALUES (4,'444@qq.com','测试四号','','123456','hello');
INSERT INTO `User` VALUES (5,'555@qq.com','测试五号','','123456','hello');
CREATE TABLE `Blog`(
    `blogId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `writerId` INTEGER,
    `page_view` INTEGER DEFAULT 0,
    `classification` VARCHAR(64) DEFAULT '',
    `content` VARCHAR(8192) DEFAULT NULL,
    `title` VARCHAR(64) DEFAULT NULL,
    CONSTRAINT user_ref_from_blog FOREIGN KEY(`writerId`) REFERENCES `User`(userId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `FavorFolder`(
    `userId` INTEGER,
    `folder_name` VARCHAR(64) DEFAULT '',
    CONSTRAINT user_ref_from_favorFolder FOREIGN KEY (`userId`) REFERENCES `User`(userId)
)ENGINE = InnoDB DEFAULT CHARSET =utf8mb4;
INSERT INTO `FavorFolder` VALUES (1,'喜欢1');
INSERT INTO `FavorFolder` VALUES (1,'喜欢2');
INSERT INTO `FavorFolder` VALUES (1,'喜欢3');
INSERT INTO `FavorFolder` VALUES (2,'喜欢4');
INSERT INTO `FavorFolder` VALUES (2,'喜欢5');
INSERT INTO `FavorFolder` VALUES (2,'喜欢6');
INSERT INTO `FavorFolder` VALUES (3,'喜欢7');
INSERT INTO `FavorFolder` VALUES (3,'喜欢8');
INSERT INTO `FavorFolder` VALUES (3,'喜欢9');
INSERT INTO `FavorFolder` VALUES (4,'喜欢10');
INSERT INTO `FavorFolder` VALUES (4,'喜欢11');
INSERT INTO `FavorFolder` VALUES (4,'喜欢12');
INSERT INTO `FavorFolder` VALUES (5,'喜欢13');
INSERT INTO `FavorFolder` VALUES (5,'喜欢14');
INSERT INTO `FavorFolder` VALUES (5,'喜欢15');
INSERT INTO `Blog` VALUES(1,1,0,'创作1','盼望着，盼望着，东风bai来了，春天的脚步近了。du一切都像刚睡醒的样子，欣欣然张开zhi了眼。山朗润起来了，水长起来了，太阳的脸红起来了。小草偷偷地从土里钻出来，嫩嫩的，绿绿的。园子里，田野里，瞧去，一大片一大片满是的。
坐着，躺着，打两个滚，踢几脚球，赛几趟跑，捉几回迷藏。风轻悄悄的，草绵软软的。桃树、杏树、梨树，你不让我，我不让你，都开满了花赶趟儿。红的像火，粉的像霞，白的像雪。花里带着甜味，闭了眼，树上仿佛已经满是桃儿、杏儿、梨儿。
花下成千成百的蜜蜂嗡嗡地闹着，大小的蝴蝶飞来飞去。野花遍地是：杂样儿，有名字的，没名字的，散在花丛里，像眼睛，像星星，还眨呀眨的。“吹面不寒杨柳风”，不错的，像母亲的手抚摸着你。
风里带来些新翻的泥土的气息，混着青草味，还有各种花的香，都在微微润湿的空气里酝酿。鸟儿将窠巢安在繁花嫩叶当中，高兴起来了，呼朋引伴地卖弄清脆的喉咙，唱出宛转的曲子，与轻风流水应和着。牛背上牧童的短笛，这时候也成天在嘹亮地响。','春');
INSERT INTO `Blog` VALUES(2,1,0,'创作1','为了看日出，我常常早起。那时天还没有大亮，周围非常冷清，船上只有机器的响声。

天空还是一片浅蓝，颜色很浅。转眼间天边出现了一道红霞，慢慢地在扩大它的范围，加强它的亮光。我知道太阳要从天边升起来了，便目不转睛地望着那里。

果然过了一会儿，在那个地方出现了太阳的小半边脸，红是真红，却没有亮光。这个太阳好像负着重荷似的一步一步，慢慢地努力上升，到了最后，终于冲破了云霞，完全跳出了海面，颜色红得非常可爱。一霎那间，这个深红的圆东西，忽然间发出了夺目的亮光，射得人眼睛发痛，它旁边的云片也忽然有了光彩。

有时太阳走进了云堆中，它的光线却从云里射下来，直射到水面上。这时候要分辨出哪里是水，哪里是天，倒也不容易，因为我就只看见一片灿烂的亮光。

有时天边有黑云，而且云片很厚，太阳出来，人眼还看不见。然而太阳在黑云里放射的光芒，透过黑云的重围，替黑云镶了一道发光的金边。后来太阳才慢慢地冲出重围，出现在天空，甚至把黑云也染成了紫色或者红色。这时候发亮的不仅是太阳、云和海水，连我自己也成了明亮的了。','海上日出');
INSERT INTO `Blog` VALUES(3,1,0,'创作1','窗外，有一棵法桐，样子并不大的。春天的日子里，它长满了叶子。枝根的，绿得深，枝梢的，绿得浅；虽然对列相间而生，一片和一片不相同，姿态也各有别。没风的时候，显得很丰满，娇嫩而端庄的模样。一早一晚的斜风里，叶子就活动起来，天幕的衬托下，看得见那叶背面了了的绿的脉络，像无数的彩蝴蝶落在那里，翩翩起舞；又像一位少妇，丰姿绰约的，作一个妩媚的笑。

我常常坐在窗里看它，感到温柔和美好。我甚至十分嫉妒那住在枝间的鸟夫妻，它们停在叶下欢唱，是它们给法桐带来了绿的欢乐呢，还是绿的欢乐使它们产生了歌声的清妙？

法桐的欢乐，一直要延长一个夏天。我总想，那鼓满着憧憬的叶子，一定要长大如蒲扇的，但到了深秋，叶子并不再长，反要一片一片落去。法桐就削瘦起来，寒伧起来。变得赤裸裸的，唯有些嶙峋的骨。而且亦都僵硬，不再柔软婀娜，用手一折，就一节一节地断了下来。

我觉得这很残酷，特意要去树下拣一片落叶，保留起来，以作往昔的回忆。想：可怜的法桐，是谁给了你生命，让你这般长在土地上？既然给了你这一身绿的欢乐，为什么偏偏又要一片一片收去呢！

来年的春上，法桐又长满了叶子，依然是浅绿的好，深绿的也好。我将历年收留的落叶拿出来，和这新叶比较，叶的轮廓是一样的。喔，叶子，你们认识吗，知道这一片是那一片的代替吗？或许就从一个叶柄眼里长上来，凋落的曾经那么悠悠地欢乐过，欢乐的也将要寂寂地凋落去。

然而，它们并不悲伤，欢乐时须尽欢乐；如此而已，法桐竟一年大出一年，长过了窗台，与屋檐齐平了！

我忽然醒悟了，觉得我往日的哀叹大可不必，而且有十分的幼稚呢。原来法桐的生长，不仅是绿的生命的运动，还是一道哲学的命题的验证：欢乐到来，欢乐又归去，这正是天地间欢乐的内容；世间万物，正是寻求着这个内容，而各自完成着它的存在。

我于是很敬仰起法桐来，祝福于它：它年年凋落旧叶，而以此渴望来年的新生，它才没有停滞，没有老化，而目标在天地空间里长成材了。','落叶');
INSERT INTO `Blog` VALUES(4,1,0,'创作2','一位烦恼的妇人来找我，说她正为孩子的功课烦恼。
我说：“孩子的功课应该由孩子自己烦恼才对呀！”

她说：“林先生，你不知道，我的孩子考试考第四十名，可是他们班上只有四十个学生。”

我开玩笑地说：“如果我是你，我一定会很高兴！”

“为什么呢？”

“因为你想想看，从今天开始，你的孩子不会再退步了，他绝对不会落到第四十一名呀！”我说。

妇人听了展颜而笑。

我继续说：“这就好像爬山一样，你的孩子现在是山谷底部的人，惟一的路就是往上走，只要你停止烦恼，鼓励他，陪他一起走，他一定会走出来。”

过了不久，妇人打电话给我，向我道谢，她的孩子果然成绩不断往上爬。

我想到，最容易被人忽略的是，山谷的最低点正是山的起点，许多走进山谷的人所以走不出来，正是他们停住双脚，蹲在山谷烦恼哭泣的缘故.','山谷的起点');
INSERT INTO `Blog` VALUES(5,1,0,'创作2','双腿瘫痪后，我的脾气变得暴怒无常。望着望着天上北归的雁阵，我会突然把面前的玻璃砸碎；听着听着李谷一甜美的歌声，我会猛地把手边的东西摔向四周的墙壁。母亲就悄悄地躲出去，在我看不见的地方偷偷地听着我的动静。当一切恢复沉寂，她又悄悄地进来，眼边红红的，看着我。

“听说北海的花儿都开了，我推着你去走走。”她总是这么说。母亲喜欢花，可自从我的腿瘫痪以后，她侍弄的那些花都死了。“不，我不去！”我狠命地捶打这两条可恨的腿，喊着，“我可活什么劲儿！”母亲扑过来抓住我的手，忍住哭声说：“咱娘儿俩在一块儿，好好儿活，好好儿活……”

可我却一直都不知道，她的病已经到了那步田地。后来妹妹告诉我，她常常肝疼得整宿整宿翻来覆去地睡不了觉。

那天我又独自坐在屋里，看着窗外的树叶“唰唰啦啦”地飘落。母亲进来了，挡在窗前：“北海的菊花开了，我推着你去看看吧。”她憔悴的脸上现出央求般的神色。“什么时候？”“你要是愿意，就明天?”她说。我的回答已经让她喜出望外了。

“好吧，就明天。”我说。她高兴得一会坐下，一会站起：“那就赶紧准备准备。”“哎呀，烦不烦？几步路，有什么好准备的！”她也笑了，坐在我身边，絮絮叨叨地说着：“看完菊花，咱们就去‘仿膳’，你小时候最爱吃那儿的豌豆黄儿。还记得那回我带你去北海吗？你偏说那杨树花是毛毛虫，跑着，一脚踩扁一个……”

她忽然不说了。对于“跑”和“踩”一类的字眼，她比我还敏感。她又悄悄地出去了。她出去了，就再也没回来。邻居们把她抬上车时，她还在大口大口地吐着鲜血。我没想到她已经病成那样。看着三轮车远去，也绝没有想到那竟是永远的诀别。

邻居的小伙子背着我去看她的时候，她正艰难地呼吸着，像她那一生艰难的生活。别人告诉我，她昏迷前的最后一句话是：“我那个有病的儿子和我那个还未成年的女儿……”

又是秋天，妹妹推着我去北海看了菊花。黄色的花淡雅，白色的花高洁，紫红色的花热烈而深沉，泼泼洒洒，秋风中正开得烂漫。我懂得母亲没有说完的话。妹妹也懂。我俩在一块儿，要好好儿活……','秋天的怀念');
INSERT INTO `Blog` VALUES(6,1,0,'创作2','照着镜子，看着，究竟镜子里的du那个人，是不是我。这是zhi一个疑问！在课室
里听讲dao的我，在院子里和同学们走着谈着的我，从早到晚，和世界周旋的我，
众人所公认以为是我的：究竟那是否真是我，也是一个疑问！
众人目中口中的我，和我自己心中的我，是否同为一我，也是一个疑问！
清夜独坐的我，晓梦初醒的我，一年三百六十五天之中偶然有一分钟一秒钟
感到不能言说的境象和思想的我，与课室里上课的我，和世界周旋的我，是否同为一我，也是一个疑问。这疑问永远是疑问！这两个我，永远不能分析。
既没有希望分析他，便须希望联合他。周旋世界的我呵！在纷扰烦虑的时候，请莫忘却清夜独坐的我！
清夜独坐的我呵！在寂静清明的时候也请莫忘却周旋世界的我！相顾念！相牵引！拉起手来走向前途去','我');
INSERT INTO `Blog` VALUES(7,1,0,'创作3','怎么独自站在河边上？这朦胧的天色，是黎明还是黄昏？
何处寻问，只觉得眼前竟是花的世界。中间杂着几条白蔷薇。
她来了，她从山上下来了。靓妆着，仿佛是一身缟白，手
里抱着一大束花。
我说，“你来，给你一朵白蔷薇，好簪在襟上。”她微笑说
了一句话，只是听不见。然而似乎我竟没有摘，她也没有戴，
依旧抱着花儿，向前走了。
抬头望她去路，只见得两旁开满了花，垂满了花，落满了花。
我想白花终比红花好；然而为何我竟没有摘，她也竟没有戴？
前路是什么地方，为何不随她走去？
都过去了，花也隐了，梦也醒了，前路如何？便摘也何曾戴？','一朵白蔷薇');
INSERT INTO `Blog` VALUES(8,1,0,'创作3','花蕾是蛹，是一种未经展示未经破坏的浓缩的美。花蕾是正月的灯谜，未猜中前可以有一千个谜底。花蕾是胎儿，似乎浑淹无知，却有时喜欢用强烈的胎动来证实自己。
花的美在于它的无中生有，在于它的穷通变化。有时，一夜之间，花拆了，有时，半个上午，花胖了，花的美不全在色、香，在于那份不可思议。我喜欢慎重其事地坐着昙花开放，其实昙花并不是太好看的一种花，它的美在于它的仙人掌的身世的给人的沙漠联想，以及它猝然而逝所带给人的悼念，但昙花的拆放却是一种扎实的美，像一则爱情故事，美在过程，而不在结局。有一种月黄色的大昙花，叫“一夜皇后”的，每颤开一分，便震出轰然一声，像绣花绷子拉紧后绣针刺入的声音，所有细致的蕊丝，顿时也就跟着一震，那景象常令人不敢久视——看久了不由得要相信花精花魄的说法。
我常在花开满前离去，花拆一停止，死亡就开始。
有一天，当我年老，无法看花拆，则我愿以一堆小小的春桑枕为收报机，听百草千花所打的电讯，知道每一夜花拆的音乐。','花');
INSERT INTO `Blog` VALUES(9,1,0,'创作3','白鹭是一首精巧的诗。
色素的配合，身段的大小，一切都很适宜。
白鹤太大而嫌生硬，即如粉红的朱鹭或灰色的苍鹭，也觉得大了一些，而且太不寻常了。
然而白鹭却因为它的常见，而被人忘却了它的美。
那雪白的蓑毛，那全身的流线型结构，那铁色的长喙，那青色的脚，增之一分则嫌长，减之一分则嫌短，素之一忽则嫌白，黛之一忽则嫌黑。
在清水田里有一只两只站着钓鱼，整个的田便成了一幅嵌在琉璃框里的画面，田的大小好像是有心人为白鹭设计出的镜匣。
晴天的清晨每每看见它孤独地站立在小树的绝顶，看来像不是安稳，而它却很悠然。这上别的鸟很难表现的一种嗜好。人们说它是在望哨，可它真是在望哨吗?
黄昏的空中偶见白鹭的低飞，更是乡居生活中的一种恩蕙。那是清澄的形象化，而且具有了生命了。
或许有人会感着美中的不足，白鹭不会唱歌。但是白鹭的本身不就是一首很优美的歌吗?--不，歌未免太铿锵了。白鹭实在是一首诗，一首韵在骨子里的散文诗。','白鹭');
INSERT INTO `Blog` VALUES(10,2,0,'创作4','假如你知道这样做并没有错的话，
那么你就继续地做下去，
不要理会别人会怎样的讥笑你。
相反的，假如你觉得事情有一点不对劲，
那么任凭周围的人如何纵容，如何引诱，你却要拒绝他们。
因为，在你心里，
一直有着一面非常清冽的镜子，
时时刻刻地在注视着你，
它知道，并且也非常爱惜你的清纯的正直','明镜');
INSERT INTO `Blog` VALUES(11,2,0,'创作4','好多年没有见面的朋友，再见面时，觉得他们都有一点不同了。
有人有了一双悲伤的眼睛，有人有了冷静的嘴角，有人是一脸的喜悦，有人却一脸风霜；好像几十年没能与我的朋友们共度的沧桑，都隐隐约约地写在他们脸上了。
原来岁月并不是真的逝去，它只是从我们的眼前消失，却转过来躲在我们的心里，然后再慢慢地来改变我们的容貌。
所以，年轻的你，无论将来会碰到什么挫折，请务必要保持一颗宽谅喜悦的心，这样，当几十年后，我们再相遇，我才能很容易地从人群中把你辨认出来。','岁月');
INSERT INTO `Blog` VALUES(12,2,0,'创作4','山茶又开了，那样洁白而美丽的花,开了满树。
每次,我都不能无视地走过一棵开花的树。
那样洁白温润的花朵,从青绿的小芽开始,到越来越饱满,到慢慢地绽放,从半圆,到将圆,到满圆。花开的时候,你如果肯仔细地去端详,你就能明白它所说的每一句话。
就因为每一朵花只能开一次,所以,它就极为小心地决不错一步,满树的花,就没有一朵开错了的。它们是那样慎重和认真的迎接着唯一的春天。
所以,我每次走过一棵开花的树,都不得不惊讶与屏息于生命的美丽。','山茶花');
INSERT INTO `Blog` VALUES(13,2,0,'创作5','　雨，像银灰色黏湿的蛛丝，织成一片轻柔的网，网住了整个秋的世界。天地是暗沉沉的，像古老的住宅里缠满着蛛丝网的屋顶。那堆在天上的灰白色的云片，就像屋顶上剥落的白粉。在这古旧的屋顶的笼罩下，一切都是异常的沉闷。园子里绿翳翳的石榴、桑树、葡萄藤，都不过代表着过去盛夏的繁荣，现在已成了古罗马建筑的遗迹一样，在萧萧的雨声中瑟缩不宁，回忆着光荣的过去。草色已经转入了忧郁的苍黄,地下找不出一点新鲜的花朵；宿舍墙外一带种的娇嫩的洋水仙，垂了头，含着满眼的泪珠，在那里叹息它们的薄命，才过了两天的晴美的好日子又遇到这样霉气薰蒸的雨天。只有墙角的桂花，枝头已经缀着几个黄金一样宝贵的嫩蕊，小心地隐藏在绿油油椭圆形的叶瓣下，透露出一点新生命萌芽的希望。
　　雨静悄悄地下着，只有一点细细的淅沥沥的声音。桔红色的房屋，像披着鲜艳袈裟的老僧，垂头合目，受着雨底洗礼。那潮湿的红砖，发出有刺激性的猪血的颜色和墙下绿油油的桂叶成为强烈的对照。灰色的癞蛤蟆，在湿料发霉的泥地里跳跃着；在秋雨的沉闷的网底，只有它是唯一的充满愉快的生气的东西。它背上灰黄斑的花纹，跟沉闷的天空遥遥相应，造成和谐的色调。
　　雨，像银灰色黏濡的蛛丝，织成一片轻柔的网，网住了整个秋的世界','秋雨');
INSERT INTO `Blog` VALUES(14,2,0,'创作5','我爱月夜，但我也爱星天。从前在家乡七、八月的夜晚在庭院里纳凉的时候，我最爱看天上密密麻麻的繁星。望着星天，我就会忘记一切，仿佛回到了母亲的怀里似的。
三年前在南京我住的地方有一道后门，每晚我打开后门，便看见一个静寂的夜。下面是一片菜园，上面是星群密布的蓝天。星光在我们的肉眼里虽然微小，然而它使我们觉得光明无处不在。那时候我正在读一些关于天文学的书，也认得一些星星，好像它们就是我的朋友，它们常常在和我谈话一样。
如今在海上，每晚和繁星相对，我把它们认得很熟了。我躺在舱面上，仰望天空。深蓝色的天空里悬着无数半明半昧的星。船在动，星也在动，它们是这样低，真是摇摇欲坠呢！
渐渐地我的眼睛模糊了，我好像看见无数萤火虫在我的周围飞舞。海上的夜是柔和的，是静寂的，是梦幻的。我望着那许多认识的星，我仿佛看见它们在对我霎眼，我仿佛听见它们在小声说话。这时我忘记了一切。在星的怀抱中我微笑着，我沉睡着。我觉得自己是一个小孩子，现在睡在母亲的怀里了。','繁星');
INSERT INTO `Blog` VALUES(15,2,0,'创作5','我在不知不觉间就参加了早觉会。
　　在住家附近有台北的四兽山，近几个月时常清晨去攀爬，认识一些早觉会的人，他们说：“林先生这么早起，也算是我们早觉会的人了。”
　　我就这样参加了早觉会。
　　像我这样的年纪参加早觉会是有一点尴尬，因为“早觉会”的成员大多数是老人和妇女，不是早已退休，就是在家中无事，才有时间把一天最好的时光花在山上。
　　我既不老不少，又是个忙人，在“早觉会”中是个异数。
　　不知道“早觉”这两个字是怎么来的，意思可能是“早睡早醒”的人。那么，是不是所有早睡早醒的人都可以说是“早觉”呢？
　　在我们这个社会，有很多人早睡早起，但是他们是为了谋求更大的权力、独揽更大的利益、追求更大的名声，他们虽然也早睡早起，但睡觉时千般计较，醒来时百般需索，这种人，算不算是“早觉”呢？','早觉');
INSERT INTO `Blog` VALUES(16,2,0,'创作6','青春有时候极为短暂，有时候却极为冗长。我很知道因为，我也曾如你一般年轻过。在教室的窗前，我也曾和你一样，凝视着四季都没有什么变化的校园，心里猜测着自己将来的多变化的命运，我也曾和你一样，以为，无论任何一种，都会比枯坐在教室里的命运要美丽多了。  那时侯的我，很奇怪老师为什么从来不来干涉，就任我一堂课，一堂课的做着梦。今天，我才知道，原来，他也和今天的我一样，微笑着，从我们年轻饱满的脸上，在一次次地重读着我们曾经经历过的青春呢。','青春');
INSERT INTO `Blog` VALUES(17,2,0,'创作6','为着追求光和热，将身子扑向灯火，终于死在灯下，或者浸在油中，飞蛾是值得赞美 的。在最后的一瞬间它得到光，也得到热了。 我怀念上古的夸父，他追赶日影，渴死在山谷。为着追求光和热，人宁愿舍弃自己的生 命。生命是可爱的。但寒冷的、寂寞的生，却不如轰轰烈烈的死。 没有了光和热，这人间不是会成为黑暗的寒冷世界么？ 倘使有一双翅膀，我甘愿做人间的飞蛾。我要飞向火热的日球。让我在眼前一阵光、身 内一阵热的当儿，失去知觉，而化作一阵烟，一撮灰。','日');
INSERT INTO `Blog` VALUES(18,2,0,'创作6','每次对着长空的一轮皓月，我会想：在这时候某某人也在凭栏望月吗？
圆月犹如一面明镜，高悬在蓝空。我们的面影都该留在镜里吧，这镜里一定有某某人的影子。
寒夜对镜，只觉冷光扑面。面对凉月，我也有这感觉。
在海上，山间，园内，街中，有时在静夜里一个人立在都市的高高露台上，我望着明月，总感到寒光冷气侵入我的身子。冬季的深夜，立在小小庭院中望见落了霜的地上的月色，觉得自己衣服上也积了很厚的霜似的。
的确，月光冷得很。我知道死了的星球是不会发出热力的。月的光是死的光。
但是为什么还有姮娥奔月的传说呢？难道那个服了不死之药的美女便可以使这已死的星球再生么？或者她在那一面明镜中看见了什么人的面影吧。','月');
INSERT INTO `Blog` VALUES(19,3,0,'创作7','真的，什么物质享受，全都罢得；没有书却不好过日子。人的尊卑，不靠地位，不由出身，只看你自己的成就。我们不妨再加上一句：“是什么料，充什么用。”假如是一个萝卜，就力求做个水多肉脆的好萝卜；假如是棵白菜，就力求做一棵瓷瓷实实的包心好白菜。萝卜白菜是家常食用的蔬菜，不求做庙堂上供设的珍果。
惟有身处卑微的人，最有机缘看到世态人情的真相。一个人不想攀高就不怕不跌，也不用倾轧排挤，可以保其天真，成其自然，潜心一志完成自己能做的事。','没有书不好过日子');
INSERT INTO `Blog` VALUES(20,3,0,'创作7','浪漫属于青春。 浪漫属于爱情。
但浪漫绝不是青春和爱情的专利。年轻时，在阳光如瀑的大街上，在剪剪的微风和如潮的人流中，你大声长吟的歌谣，为什么今天不能唱？初恋时，在花前月下，在澄明的清晨或朦胧的黄昏，你曾经一次次献给你心爱人的那 一朵朵玫瑰，为什么不能让它再重新地绽出一缕温馨？
在柴米油盐的纷杂里，你可以拣一个细雨霏霏的夜晚，熄灭灯烛，伏案面窗听那斜风，听那细雨，听窗棂下蟋蟀跌跌宕宕的高吟短唱。或在风清月白的夜晚，独卧阳台把酒临风，面对灿烂的星空和皓月，吟李白的“花间一壶酒，独酌无相亲”，替东坡抒情：“明月几时有，把酒问青天......”
在家事国事天下事的烦务里，你可以忙中偷闲到柳浪闻莺的河边去垂钓，也可以邀上两三个友人到郊外去看云舒云卷，更可以选一处斗室听一听贝多芬或柴可夫斯基，或者和一帮友人吹牛对弈侃大山。
在平淡的日子里，你可以用油渍斑斑的手拨电话的号码，给妻子说几句温馨的俏皮话或倾吐几句真诚而幽默的祝福。也可以在女儿的生日里，做一只傻冒的唐老鸭南腔北调地给她唱一首祝福生日的歌。
别羡慕一个白发苍苍的老诗人为什么总有那么多的人去爱他亲近他。因为写诗的心永远都保持着不褪色的纯真和浪漫。
别妒嫉一个走下舞台的老演员为什么总比他在台上活得更辉煌。因为他留住了一生戏剧生活里全部的浪漫。
留住浪漫。柴米油盐是淹没不住浪漫的，浪漫是生活五味中最具味道的一味，有了浪漫，你的一生才会有滋有味。
留住浪漫。浪漫是没有年轮和时间的，八十岁的老人依旧可以从浪漫里寻拾回十七八岁豆蔻的感觉，金婚的夫妻依旧可以从浪漫里寻拾回初恋的情愫。
留住浪漫，你就留住了年轻！ 留住浪漫，你就留住了温情！','浪漫');
INSERT INTO `Blog` VALUES(21,3,0,'创作7','凸起在地表上，因之而高耸。鸟瞰地球，成为一道道脊梁，即是山脉之灵。因高度的无法企及遂成伟大，因信念的坚定而撼之不动，终于铸成出色的品格。困难已至极限，战而胜之乃成就辉煌，这便是山之魂。山脉的出现，使草树惭疚生妒，争先占领山脉，以为胜利。五岳的扬名，打起了游人的脚泡，珠穆朗玛的高度，埋葬了不同肤色的强者。山，也秀丽，也迷人，也险绝。 有一座山脉，遍布荆棘，恶石丛生，山顶有石礅，此名：理想。有一座山脉，看似平实，实则绚丽，游者众，而尽兴者寡，称之为：人
生。有一座山脉，虽低如丘，不可睥睨；虽高入云，不惮攀援，踩在脚下垫脚，举过头顶无法前行，名曰：历史。山脉重重，欲揽之，必须踏实每一步。
侏儒的祈祷 。我是个只要身穿彩衣、献筋斗之戏、享受升平之世就知足常乐的侏儒。
祈愿让我如愿以偿。祈愿不要让我穷得一粒米也没有，祈愿也不要让我富得连熊掌都吃腻了；祈愿不要让采桑农妇都讨厌我，祈愿也不要让后宫美女都垂青于我；祈愿不要让我愚昧到良莠不分，祈愿也不要让我聪明到明察星象；祈愿更不要让我成为英武勇敢的英雄。我现在每每在梦中上难攀之峰顶，渡难越之海洋——也就是在做着使不可能的事成为可能的梦。每当出现这种梦境，我并不觉得可怕。我正苦于像和龙搏斗似的和这个梦搏斗。请不要让我成为英雄——不要让我产生想做英雄的欲望，保护这个无力的我吧！我是个只要被这新春的酒灌醉、吟诵这《金缕》的歌，过上这美好的日子就知足常乐的侏儒。','山脉');
INSERT INTO `Blog` VALUES(22,3,0,'创作8','享受冬天，坐在田园的篱笆上，领略那片静谧的轻松。享受冬天，坐在大都市的立交桥上，欣赏穿梭人群中写满沧桑的面孔。享受冬天，坐在火炉旁，倾听一个个娓娓道来的故事。享受冬天，坐在山巅，感受大自然的粗旷与旷达。守住冬天的这片寂静，抛开心中的忧虑，便会走进抒情诗的意境。站在白皑皑的雪地上，享受纷纷扬扬的柔性，做个儿时的快乐的梦。走在呼啸的山风里，去与冬天较量，去与冬天摔打，去与冬天拥抱。让残酷雕塑你的青春，让挫折铸造你刚毅的灵魂，让失败锻炼你不灭的韧性。让寒风吹乱你的黑发，让酷霜降临你的肩头，然后去谱写青春的雄浑。冬天为勇者喝彩，把怯懦者击得粉碎。
冬天像个憋足劲的小伙子，穿着朴实无华的外衣，跃跃欲试，为自己事业的辉煌孕育了青春的激越。冬天是果实灿灿的秋天的延伸。冬天是风和日丽的前奏。我们不能沉醉于那片秋之收获，要把自己的汗水融入冬天的缓冲与再造，让我们幢憬的春天更富有魅力。秋天里写不完的曲子，你尽管搭个生命的温室，再继续动听的歌谣；春天里要勃发的风景，在冬天里做量的积累。冬天里没有孤独和忧伤，有的是悠悠的白云，明净的天空，凌空的白鸽?......无边的风景。
冬天是一封浓浓的情书，读不透它冷峻里的温柔，也读不透它温柔里的高远。冬天是一本厚厚的历史，看不尽它包含着几何生存的哲理，也看不尽它包含着多少衰亡的借鉴。冬天是一瓶醇香的老酒，让你痴醉。','享受冬天');
INSERT INTO `Blog` VALUES(23,3,0,'创作8','往事是什么呢？它们从哪儿长出来？开花吗？结果吗？我们的一生都有往事相伴。在我抽烟的时候，我有这样一种感觉。那闪烁着的烟头在一点一点地燃烧着时间。幽幽窜出的白烟，如同往事。它们在我们肺腑和身体内留下一种滋味。一种气息。纠结在我们的日子里。我们无法忘怀这种味道。之后，又在我们眼前缭绕不散，将眼前的现实朦胧起来；之后，我们就看见了往事。
我们从来不知道自己会记住什么往事。 从不知道。
只要真诚而坦然地去生活，该记住的自然会记住。许多往事就如此交替存在。就像我们口中不断吐出的烟，一缕一缕。只要我们活着，往事就不会断绝。
往事的花开满在我们柔韧的心里。而那些痛苦的果子，也只有柔韧的心才能承受、品尝。
对于往事，欢乐或伤感同样很多很多。','往事');
INSERT INTO `Blog` VALUES(24,3,0,'创作8','岁月滑翔的声音就像鸟儿舒展羽翼的声音。宛若赤足走在沙滩上，许多的日子如潮水漫过双足，退去之后，了无印 痕。
岁月，无声地伴你走过春夏秋冬。群山在无声中诉说伟岸，江河在无声中书写恢宏，蓝天在无声中坦露旷远，大地在无声中酿就永恒。人呵，亦在无声中，送走时光的星移斗转，笑看人间的月圆花瘦，把持心灵的阴晴曲直，掂量生命的跌宕浮沉...... 岁月，悄然地充当生命的证人！有贤者言：日月经年，世事无常；人生如月，盈亏有间。每个人的人生如同在时光的隧道里做了一次漫长而艰辛的旅行，途经之处，看到的不尽是山青水绿、歌舞升平，更多的却要领略崎岖坎坷或平淡无奇。这时候，尚未到达目的地的你，浑身乏力了，双眼蒙尘了，甚而启程时高昂的兴致也聚然冷却了——这是岁月本身蕴含的一种冷酷而坚实的力量，也是岁月对人类生命韧性的一种挑战！
在一些平淡的日子里，我们平静甚而不拒凡俗地活着。我们那颗被生活磨蚀得有些麻木的心，难免嗟叹于岁月的无情和命运的多舛，甚而心安理得地让青春做了岁月的附庸。然而，当我们用心去揣摩生活中类似于老蚌衔珠、蛹化为蝶、万涓成河的人生规则时，你会幡然顿悟：那不正是平凡生命历经苦痛与岁月抗衡而编织的辉煌，不正是有限生命在无涯岁月中定格成永恒的 证明么？那么，请慎读岁月吧，不仅仅在你生命的显目处——诸如点燃生日蜡烛或者伴随新年钟声跨进新年的那一刻。
慎读岁月吧，也不仅仅在你人生的风光处——诸如幸运之神叩响门扉或者在鲜花和掌声中走向领奖台的那一刻。
慎读岁月，最是应当在你平凡生命中的每一天——因为生命是对岁月的回眸，人生是与岁月的较量，征服了岁月，也就获得了超越生命年轮的青春!','岁月无声');
INSERT INTO `Blog` VALUES(25,3,0,'创作9','不要希望人类是完美无缺的，不要希望每一个人都像圣人一样是完全舍已为人的，不要这样希望！我认为，我们这样承认，并没有什么不好。而且惟有这样承认了之后，我们才可以对人间多存几分原谅，少受一点失望的打击。假如你为人间冷酷而难过，那么你唯一能做的事就是由你自己发出光和热，使人间减少一分冷酷，增加一分温暖。假如人人都停止抱怨别人，而由自己本身去发光生热，这人间就温暖得多了！
不要希望人们一点也不虚伪。你只能希望人们在虚伪之中仍不忘善意，并且希望人们能在该诚恳的时候诚恳，这就够了。
不要对人类失望！我们生就是这个样子的。有好处，也有缺点；有可爱的地方，也有令人失望的地方。能承认这些，我们才可以用宽容的态度来对待人生。','睁眼看人生');
INSERT INTO `Blog` VALUES(26,3,0,'创作9','静静地看人生，慢慢地回头，那些往事里总有一些温暖的迷惘，即使结局已是一个确定的答案，但我们的心仍然徘徊在其中，有时候甚至不能自拔。人生总有遗憾，所以难免会有无奈有悔恨，如果总是沉醉其中，那么生活将会是一种灾难而毫无乐趣可言。曾经从收音机里听到有这样一个女孩，他的男友和她分了手但没有说任何理由，于是痴心的她拒绝了其他异性的追求，苦苦地等了两年，因为她要有个说法，她要他给一个理由，如此的等待最后的结果是等来了他要结婚的消息。这样一个故事留下来的是无边的创痛和对那两年青春时光的无比痛惜，难道生命中真的只有执着和不能忘却吗？我想起了一盘磁带扉页上的一句话：从前以为拥有是幸福的，现在却明白舍得才是美满。
当我们以一种平淡的心情打开记忆时，看那些留在岁月里的心结便宛如天上飘动的云，卷卷舒舒，而许多美好的或者不美好的感觉就会扑面而来，因为淡泊，所以便可以从容面对。
坐看云起，明白了平平淡淡才是真，那些回忆似轻烟拂面而来又随风而去，心中或许有一刹那的惆怅，但这种些微流动的感觉已不能再伤害我们了。坐看云起，我们在乎的不再是云起处那个莫测的世界了，满眼只是那种变幻的奇妙的美丽，满心是宠辱不惊的那种悠闲和快乐，也许我们的人生仍然充满波折，可是我们的心里已没有患得患失的懊恼和大悲大喜的起落情绪。日子如流水匆匆地逝去，站在现在展望未来回顾过去，总有一些留下，总有一些逝去，选择一个你喜欢并且感到舒适的姿势坐看云起，心中有感动但已无言。','坐看云起');
INSERT INTO `Blog` VALUES(27,3,0,'创作9','打开坚冰的闸门，“哇”地一声，春水哭了——为了一冬监禁的委屈，也为着春来自由的释放。春水，义无反顾地向前，以它新生的无比活力向前冲刺，撞击。它把一块块巨大的冰凌举起来，摔下去，再举起，再摔下，直至摔成粉末，融在自 己的怀抱里。
春水胜利了，但它并不排斥异已，它偕同将融未融的冰块一道向前流去！我看见，它泛起欢快的浪花，幸福地哭了，仿佛告诉沿路的每一棵树，每一株草，每一个匆匆的行路人：“快来分享斗争与团结的欢乐吧！” 是的，欢乐的奔流是无敌的，任何力量都无法把它阻挡！春水，我愿随你同去......','春水');
INSERT INTO `Blog` VALUES(28,4,0,'创作10','啊，青春，青春，你什么都不在乎，你仿佛拥有宇宙间的一切宝藏，连忧愁也给你安慰，连悲哀也对你有帮助，你自信而大胆，你说：“瞧吧，只有我才活着。”可是你的日子也在时时刻刻地飞走了，不留一点痕迹，白白地消失了，而且你身上的一切也都像太阳下面的蜡一样，雪一样地消灭了。......也许你的魅力的整个秘密，并不在乎你能够做任何事情，而在于你能够想你做得到任何事情——正在于你浪费尽了你自己不知道怎样用到别处去的力量；正在于我们中间每个人都认真地以为自己是个浪子，认真地认为他有权利说：“啊，倘使我不白白耗费时间，我什么都办得到！”
我也是这样??那个时候，我用一声叹息，一种凄凉的感情送走了我那昙花一现的初恋的幻影的时候，我希望过什么，我期待过什么，我预见了什么光明灿烂的前途呢？
然而我希望过的一切，有什么实现了呢？现在黄昏的阴影已经开始笼罩到我的生命上来了，在这个时候，我还有什么比一瞬间消逝的春潮雷雨的回忆更新鲜、更可宝贵呢','青春的呼唤');
INSERT INTO `Blog` VALUES(29,4,0,'创作10','绕梁的紫燕是温柔的，它要用这种美好的东西，来熏陶和哺育幼辈；代烈日暴晒补过的月光是温柔的，它将平和、清凉的银辉洒向大地，轻缓地抚慰被灼伤的记忆；滴嗒滴嗒的台钟是温柔的，它安稳而又体贴地踱着，从不惊扰每个香甜的美梦；少nv的心地是温柔的，一个姑娘如若不具备这点，那她还能有多少魅力呢？
有的人，在妈妈怀里撒娇的时候是温柔的，以后命运将其拔弄得不成样子，温柔随同人生的价值被一起拍卖了；有的人，生来匮乏温柔的细胞，可是几经风雨之后，生命之树的根部却长出了温柔这只蘑菇。
诚然，温柔常与爱恋、仁慈为伍，常跟宽厚、善良做伴。不过，谁要以为温柔同“软弱无力”有什么瓜葛，那就有失公允了——春风算得上温柔了吧，它从冻结的河面上走过，坚冰竟出现了裂缝；棉花称得上温柔了吧，蹦得再高的棉球一落到上面，就此弹不起来了；友谊也该是温柔的吧，可它能叫铁骨铮铮的硬汉愧悔不已，潸然泪下。
温柔，何其神奇微妙的东西。你几乎看不见，听不出，摸不着，却能感受得到。它是一种慈祥、热诚、仁厚、道义和爱的结晶体，它坚强有力，它与美丽并存。','温柔');
INSERT INTO `Blog` VALUES(30,4,0,'创作10','自由是感觉不到的。这就是深刻的格言。感觉不到的就是“无”，就是无为。我们能感觉到的是不自由。当我们说自由时，说自在时，是因为我们还感觉到不自由、不自在。或者，起码是我们曾感觉到过不自由、不自在。感觉到自由了，自在了，那是因为还残存着些微的不自由，不自在，至少还有着不自由、不自在的记忆。其实，即使我们只是记着过去曾有的不自由、不自在，那么，它仍然具有一定程度的现时意义。真正的自由，就是彻底的“无”，就是连过去的不自由， 也毫无印象。','自由');
INSERT INTO `Blog` VALUES(31,4,0,'创作11','飞瀑之所以能飞流直下一泻千里，除了它有深厚的积聚之外，就是因为它选准了一个突破口。千里良驹闯进迷谷，急需的不是在断崖绝壁上的左冲右突，而是冷静地分析出路在何方。撞了南墙不回头，勇是勇了，但这实属不堪称道的匹夫之勇，人何苦要在一棵树上吊死？现代人应该学会选择。看见别人下海，游得那么舒坦那么潇洒！你想跟着下海前，首先了解一下海的深浅和自己是否是只旱鸭，人到了抵抗不住you惑时，往往忘掉最起码的常识。
从众心理亦是一种可怕的隋性，看见别人都往同一条路上拥，自己亦拼命往那条路上挤。其实，如能果敢地另辟蹊径，寻找一条适合自己潜行的小路，最后你会惊喜地发现，你比别人早到目的地。
只要心中有奔突的内火，哪怕前面挡道的是一座无法绕过的冰山，亦可以把它熔掉。人到了别无选择的时候，只有高擎力量和智慧的火炬勇敢地突围机遇，像一条纵横交错的河流，向任何人都开敞着，只要你准备好舟楫，你随时可以荡起你那希望的双桨。至于你能否闯出那八卦图般的迷阵，到达理想的彼岸，这就不仅要看你划船的功力与毅力，而且要看你选择航道的本 领了。
选择，不要奢望一次成功，这要有赖于漫漫人生路上感性的积聚与理性的升华。感性的积聚使人聪敏，理性的升华使人睿智。这种积聚与升华到了家，那梦想成真便不是一句海市蜃楼般的空话。','选择');
INSERT INTO `Blog` VALUES(32,4,0,'创作11','我们总认为，温柔是她们的天性和贤惠驯服的同义词。其实未必，温柔对于男人更是一种力量，用泰戈尔的话来说，女人的一半是神。
我们总认为，只有男人会造就她们。其实未必，坚强不屈了多少次，使她们往往更能铸成一个强男人。我们总认为，她们没有男朋友是因为太孤僻清高。其实未必，她们找不到男朋友常常是男子太怯弱了。我们总认为，爱与不爱应该属于男人。其实未必，男人主动的爱常掺有专zhi的欲望，而她们一旦爱起来，往往更主动、更强烈、更真挚。
我们总认为，她们应该贤惠，有女性的表现尺度。其实未必，一个女人要强常常只是为了维护自己独立的人格。
我们总认为，她们在事业上成功便什么都有了。其实未必，在某种压力下，她们在生活中失去的会更多。我们总认为，眼泪只属于她们。其实未必，把眼泪放在心上作为负担，使自己消沉下去的往往是男人。','其实未必');
INSERT INTO `Blog` VALUES(33,4,0,'创作11','既然活着，就不妨像水，点点滴滴都是真实的生命。常听你感慨，一个人并不懒惰，也不庸俗，更不少才干，然而活得却未必尽兴。这困拢一直在折磨着你，使你常常在一次短暂的顿悟之后，又落入一个更深的蒙昧之中。从此你紧锁的眉宇间发源了一条长长的愁之河，只会在流星掠过的夜空下用琴弦交换自己孤独的故事。你说年轻的心只会不打伞地走入如泣的雨中，只会在不醒的早晨执着于那个摇曳了千年的梦幻。这个时候，尽管你仍然是山，却过早地荒凉。你漂泊的经历使你确信，青春只不过是黑夜讲过的一个黑色标题。
然而，这不该是你全部的故事，因为你明亮的眼睛仍然证明着初春的雨，你该在飘飞的雨中抖落一身风霜，用你细瘦的手指在大地上用力写下：我感 谢生活，相信未来！
同样是以沉默作序，这次你的书又翻开了一个崭新的情节，你起身走向陌生的草洲，让脸上的愁云慢慢步入天空，你细心晾晒潮湿了的青春，让青春成为骄傲的歌，汩汩流入时代的耳鼓。我看见你飘逸的长发收纳了强劲的风，听见你生命的竹林里嘎嘎的拔节声，于是你真正开始学会了笑，学会了生活，学会了在你年轻的心壁上，默默雕凿一种Ji情、一种信仰、一种向上的力量。
生命，需要在时空的经纬中慢慢沉淀出它的价值，尽管那个时候干坤缄默，天地不醒；生命，也该在超越了晨昏的日界线后再次起程，让所有流动的血和热情，重新染上太阳辉煌而沉重的指纹','太阳的指纹');
INSERT INTO `Blog` VALUES(34,4,0,'创作12','阳光是匆匆的过客，总是去了又来，来了又去。他不愿意停留。不，他也曾暂时在一些梦里徘徊。
他徘徊在沙漠的梦里。沙漠梦见了花朵、云雀、江河和海洋。他徘徊在海洋的梦里。海洋梦见了地震、小山、麦浪和桑田。他徘徊在老人的梦里。老人梦见了骏马、青草、角力和摔交。他徘徊在婴儿的梦里。婴儿梦见了母亲的歌声、乳汁、胳膊和胸膛。每个带黑色的梦都闪亮。每个梦都保持着一分阳光。阳光是个不倦的旅客，他总是来了又去，去了又来。他不能只在梦里徘徊。 他在梦的外面弛骋。
他制造一个个梦，更制造一个个觉醒。他驰骋，在梦的外面驰骋。','阳光');
INSERT INTO `Blog` VALUES(35,4,0,'创作12','今生，什么能与你永相伴？
恩爱夫妻，有多少是同年同月同日去的？“生不同死同穴”是诗情画境。事业，纵然可达到登峰造极的地步，但在身老体衰时，创造力会枯萎。金钱，没钱时，阮囊羞涩，你气不顺；有钱时，人情淡薄，你又顺不过容颜，青春不能常驻，有的短促得像梦。还有什么？心情，它如同呼吸，伴你一生。人的一生，免不了有许多苦难，苦难时的心情像船桨打水，吱呀一声便坏了，坏得透底。茶饭不思睡难安，半生的汤圆久久梗阻在心，除了给周围带来有碍观瞻的审美缺陷，除了给自己种下病根，好处是丁点没有。
好心情就不同了。好的心情能化干戈为玉帛，化疾病为健康。任何年龄的容颜都会被好心情照亮。其实，我们每个人都需要好心情，它是生命赋予我们的本能，没有谁为阴郁、凄苦而降生于这个世界上。好的心情和性格一样，虽有先天的基因，却主要来自后天的修炼，它不会诞生在某一个时刻，而是天长日久中人格、素养、品质、才情的自然流泻。好心情的获得不需选择天时地利，它如美的存在是无所不在的，关键在于你愿不愿发现。同样是人在旅途，有人只死盯目的地，亦苦亦累且躁；而你注重过程，
一路听鸟语闻花香，涉泉河跋丘岗，瞻冷雨空阶怀西窗秉烛，看潮起潮落随 雁去雁来。
皎洁的夜空下，有人闻不出十里荷塘飘来的花香，你却在细小微风中听到了荷叶与蜻蜒缠绵的耳话。','与好心情相伴');
INSERT INTO `Blog` VALUES(36,4,0,'创作12','我喜欢温和的一切，我希望一切都是温和的。
我希望天空是温和的，不暴烈，不阴翳。阳光四季和煦地洒照大地，冰霜消融，草绿花馨，百鸟鸣啭，心境明朗。
即便是下雨，我也希望是温和的雨丝伴随轻盈的风，拂面掠额之际，带来一缕似水柔情。
我希望每张脸上都有温和的笑容，冷笑、讥笑、讪笑都在真诚的氛围中悄然消散。一颗颗坦然仁爱的心灵，可以温和地交流。
我希望一切问题都以温和的方式解决，不消极、不冲动、不偏颇。态度和语言都是温和的，相待、相谈，既没有拒人于千里之外的冷漠，又没有笑里◇◇的虚伪。
让心中的冰凌和脸颊的霜雪在温和中溶化了吧。让互不相让的争斗在温和中平息了吧。我们一起来缔造一个温和的世界，那该多好，多美。','温和');
INSERT INTO `Blog` VALUES(37,5,0,'创作13','人生就像一个五彩线团，不论什么时候，只要顺着时光轻轻抽出一缕来，你就会从这往昔生活的经纬上发现人生的各种折光。最令人留恋的要算它的开头——你一无所知地降临于这个世界，睁开眼，展开耳廓，你激动了。这世界居然这般明朗宽敞！比之那温暖却混沌的母体美多了。那时你的心中满是花的馨香，草的清新，还有母亲摇篮旁充满爱心的低唱......
渐渐地你会发现世界不只是纯美，生活洋溢着暖色，也不乏暗淡，它悄悄地变幻着??生活的主色调总是绿色的，成长中你有过无数次等待和希望。遥远的，曾希望自己长得像大人一样高；焦急而又惴惴不安地等待公布考试成绩......等待的内容时时变化着，它you惑你不断向前。瞧，前方又一束绿色在摇曳。
有时生活是蓝色的、忧郁像一张网笼住你。可别以为你经受着比别人更多的磨难，是世界最痛苦的人。烦恼时，劝你找朋友倾吐，借友人的一方晴朗，你可尽情稀释痛苦，同时你会发现，外面的世界广阔而精彩。有一天你会明白，痛苦本是一种财富。
生活又是玫瑰色的，不去想是否能赢得爱情。既然衷情于玫瑰，倾心于“王子”，就去勇敢地表露，追求本身就是幸福。生活常常富于黑色的幽默，开个玩笑，绊你个跟头，有时足以使你万念俱灰。但记住，生活不会逼你至绝境，留心一点儿，前方若隐若现的光亮会引导你走出黑暗，你大可不必感慨唏嘘，甘于沉沦，那无异于自我残害。
生活也是金黄的。多梦的季节，你总是把秋日的硕果幻入梦境，双肩驮着神圣的使命和卸不了的责任，需要你在更广博、更宽阔的时空和人海里，挥洒汗水，用智慧叩响成功的咏叹，这样你就拥有了闪烁的青春，拥有了终生的丰润。
回味着各种变幻的颜色，你该相信，世界之所以有了我们，是因为它需要更美好，需要我们用更明丽的颜色丰富它','生活的流行色');
INSERT INTO `Blog` VALUES(38,5,0,'创作13','一云游僧曾问佛祖：“我存在吗？” 佛祖不答。又问：“我不存在吗？” 佛祖仍不答。
云游僧失望而去。弟子阿难不解，问佛祖为何不答。
佛祖云：“问‘我是谁’，意味着寻找生活道路。而生活道路不能一言以蔽之，因为道路还没有走完。”
“我是谁”，是每个人面临的不言而喻的常识和生活前提，但又是一个令人百思不得其解、求索终生的难题。因为人是边走边问，发问的时候，已是人在旅途之中，个人的自我，还没有最终定形。于是，人只好边走边问，路没走完，就没有最后的答案：路若走完了，要这个答案也没什么意义了。关于个人的自我，不会有终极答案，这答案就在人生的一串串脚印之中。你是谁？你就是你走过的那一条条道路，就是你在世间留下的那一个个忽隐忽现的痕迹。人生在世，要珍惜人生的每一个段落。每一个段落都是你自己，一旦写下就永远都抹不掉，无论是耻辱还是辉煌。人生中既没有永远的落伍者，也没有永远的幸运儿；既没有永远的懦夫，也没有永远的英雄。萨特说得好，人不是裁纸刀，裁纸刀注定是裁纸的，但人可以改变自己。
珍惜生活的脚步，因为人生不能重复。我很欣赏卢梭的那句名言：“我独一无二，我知己知人，我天生与众不同；我敢说我不像世界上的任何人。如果我不比别人好，那么我至少跟别人两样。大自然铸造了我，然后就把模型打碎了......”','说你说我');
INSERT INTO `Blog` VALUES(39,5,0,'创作13','哦，大山。我心中的男子汉，沉积了多少年的传说，叠出一个力的形象。
你不曾给我许诺，生活就是沉默。然而，那枚金果的you惑，使我爬上山坡。那是一束湖绿的追光，滑过雨后的半天，像一条宣泄的小溪，舞动着那将要凋残的绮丽，为大山把胭脂涂抹......你说，男性的美是力，不愿用女色遮挡苍白。你的呼喊是风，你的汗水是雨，你是一个永不驯服的魔王，心中积郁了几千年的澎湃。你的生命就是 一首悲壮的歌。
那遥远的记不清的岁月，你的摇篮是海，还是苍茫荒野？你可曾孤独，你可曾寂寞？那黑黑的长夜，可曾有女魔的神笛给你欢乐？啊！我想问的太多，太多，你仍是沉默。生命绿了，那是三春恩赐；杜鹃笑了，那是夏情甚殷。哦，你总是这样，这样原始地保存自我。
长长的梦幻，该是人生的思索。不绝的赞叹，涌起力的潮波。 那枚金果腾升了，大山腾升了。
啊，大山，我心中的男子汉，你不曾给我许诺，却给了我许多，许多。','大山');
INSERT INTO `Blog` VALUES(40,5,0,'创作14','也曾经历过失落的痛楚，但我们从不把悔恨的旧梦重拾。既然秋天的落叶早已消融在我们生活的大地，化做滋养生命之树常青的甘乳，又何必再去寻寻觅觅那份感伤的情怀？面对岁月之轮永不停歇的步履，沉浸往事只能倾斜心灵的天平，寻觅过去只能拾回尘封的梦幻。
作别西天缥缈的云彩，我们步入情深意浓的黄昏。纵使失去皎洁的圆月，我们尚且拥有满天闪烁的繁星。当我们还在温柔的梦乡中流连忘返，黎明已悄然来到身边。生活赠与我们的是许许多多实实在在的丰富意蕴，我们岂能被人生的风风雨雨和云遮雾绕迷蒙住双眼？告别过去，正是为了珍惜现在和开拓未来。当我们把所有的痛苦与悲伤埋进昨天，我们便真正拥有了一个崭 新的今天。
人生本是由一连串的遗憾组成的。我们何必对生活中的遗憾耿耿于怀。面临岁月之河，人生只有在向彼岸进取的征途中，才能焕发迷人的光彩。','彼岸');
INSERT INTO `Blog` VALUES(41,5,0,'创作14','一个明智的人早晚总会发现，生活是欢乐与悲哀、成功与失败、给予与获得的聚合体。他懂得能不为琐事而大动肝火对于成功是至关重要的。 他懂得不善驾驭自己情绪的人总会有所失。他懂得摆出好斗的架势最易导致冲突。 他懂得任何行为总会像甩出的飞镖一样落回来。他懂得沉溺于说长道短地议论他人最能使自己信誉扫地。
他懂得去尊重每一个人；他懂得一个“早安”和一个微笑能使人获得一天的快乐。
他懂得用肯定和赞许去振奋别人的精神的同时，也是振奋自己的心灵的最佳途径。
他懂得当他落难或失败的时候，世界并不是末日，新的一天和新的机会总在前面。
他懂得听往往比说更重要，让别人诉出心中的烦闷总能结交更多的朋友。他懂得每个人都会有烦恼，他不会因别人的怨怼而消沉。
他懂得一个地方的人并不比另一个地方的人难相处，相处的和睦与否百分之九十八取决于他自己的所做所为。','生活的艺术');
INSERT INTO `Blog` VALUES(42,5,0,'创作14','相遇，相识。相谈，相知。相别，相思?? 所有的开端都是这样的。
所有的结局呢？多么希望有一个美好的开端都有一个美好的结局。
多么希望每一个简朴、流畅的夜，很深很深，很长很长，仿佛永远走不到边缘。
就这样，漫不经心地走进去，走下去，当所有的情节一一走完，那便是结局了。
幸福的结局使人完美。 不幸的结局使人毁灭。
然而，世上有许多你以为幸福的人不一定幸福，许多你以为不幸的人也不一定不幸。
为什么凡事都非要有一个确切的结局不可呢？古往今来多少凄楚动人的故事之所以百世流芳，正是因为它们永远不会有什么结局。
然而，那或许便是最完美的结局了。','结局');
INSERT INTO `Blog` VALUES(43,5,0,'创作15','简单地生活，不是如佛家般脱离红尘，置身世外；也不是如庄子般主张“绝圣弃智，擢乱六律”，而是以一种澹然的心境宽待生活，在“风烟俱静，天山共色”的悠然襟怀中，体会“天凉好个秋”的情怀。
简单地生活，也不是凡事无争，敷衍生活，而是心平气和地从事你的工作与生活。独处斗室时，你思接千载神游万仞，在书林翰海中徜徉忘神；挚友相聚时，你舌粲莲花触处逢春坦荡磊落，在亲情与友情中怡然自乐；就是在平凡的家庭生活中，你也能因妻子动情的娇嗔而如沐春风，因孩子可爱的迓语而快慰不禁。甚至最单调的锅碗瓢盆交响曲，你也完全可以换个角度去欣赏去赞美：“呀，简单的劳动正在丰富和美化着我们的生活！”......总之，在纷繁的世界中抛去苛求，简单地生活能帮助你重新找到迷失了的自我，恢复为利欲蒙蔽的本性，使你多一份诗意，多一份潇洒，多一份平和，多一份自我欣赏与肯定！
有位哲人说：“真正的财富，是健康的身体、简单的生活和心情上的海阔天空。”在诸多示顺与不平时，此话使人蓦然觉醒：
原来我们对生活牢骚满腹，首先是由于我们自己的生活太复杂；我们怀疑外部的事物是否合理，首先是由于我们对自己本身是否合理有怀疑！真正值得珍惜的不是其他，而是不为物累的睿智、平淡隽永的自得、真诚无欺的自爱，简言之，即简单地生活。
苛责生活，晴空满是阴霾，四顾尽成危道。宽待生活，恶澜可成清流，狂飚自成和风。简单地生活，潇洒就在自身，红尘便是福地！','简单的生活');
INSERT INTO `Blog` VALUES(44,5,0,'创作15','都怪他的血液是混浊的，都怪他过于狂妄，都怪他日夜不停地呼啸，都怪他染污两岸的土地，缺乏山泉般的纯粹。他苦闷极了。他梦想化为洁净的水，梦想着仙境似的肃穆与静止，梦想着不再疲倦地奔走，梦想着像明镜一样清澈，可照着许多游人快意地微笑。然而，他又厌恶这些很美的梦。 他总是固执地爱着自己不息的沸腾，总是爱着自己追求大海的狂妄，总是爱着自己和高山峡谷搏斗的呼啸，甚至总是固执地爱着自己的混浊，奔流着的混浊，跳动着生命大脉搏的混浊。
他知道他的混浊打湿过河岸，然而，这混浊也灌溉过田野，养育过黄黄绿绿的新鲜与繁荣。
他知道有奔流就有呼啸，死亡总是静悄悄的。他知道有奔流就有泥沙，死亡总是苍白而干净的。他苦闷极了。然而他已不再苦闷，他知道惟有不息地奔流，才有超越高山峡谷的壮观，才有明天无边无际的壮阔......','大河的苦闷');
INSERT INTO `Blog` VALUES(45,5,0,'创作15','流岚飞雾，峰峙崖端，山后叠山，海上升月，都让人心旷神怡。浩叹天宇广袤，神州万象。
欣赏，也未必要置身影院。飞瀑轰谷，烈马长啸，耕牛欢哞，鸟鸣啁啾，皆让人流连忘返。陶醉于鼓瑟吹笙，转轴拔弦。真正善于欣赏的人，无处不可以欣赏：上坡时的蹬足，逆流中的奋篙，盲人挪动的拐杖，乃至一块丑石、一截根木?? 真正善于欣赏的人，无时不可以欣赏：公鸡的雄唱，纤夫的浑号，列车 开启时的引笛，乃至夕晖里的一阵夯声，婴儿的一夜长啼，水田上的一片蛙鼓......
善于欣赏顽童，功在他独具慧眼。善于欣赏根木，高在他独运匠心。善于欣赏嚎啕中的悲壮，他必定饱经沧桑。善于欣赏残缺中的奇美，他必定深谙花好月圆。只是欣赏花容玉颜、海誓山盟，是欣赏者的肤浅。 只是欣赏俯首贴耳、拍马溜须，是欣赏者的低劣。只是欣赏金钱，难保证他的人格。 只是欣赏顺达，断不定他的挫折更多。平庸者的欣赏只在有字处读书有声中听乐。深刻者的欣赏在于欣赏纹络里镌刻的思想无声处滚动的惊雷。要善于欣赏他人——善于欣赏对手，他才可以襟怀磊落，避短扬长。
更要善于欣赏自己——善于欣赏自己，他才可以临危不惧，棋出高筹。船欣赏了帆，船以远行；箭欣赏了弓，箭以远射。更多地欣赏生活，生活更多地欣赏他。 善于欣赏，便是善于真正地生活。','欣赏');
CREATE TABLE `BlogFolder`(
         `userId` INTEGER,
        `folder_name` VARCHAR(64) DEFAULT '',
        CONSTRAINT user_ref_from_blogFolder FOREIGN KEY (`userId`) REFERENCES `User`(userId)
)ENGINE = InnoDB DEFAULT CHARSET =utf8mb4;

INSERT INTO `BlogFolder` VALUES (1,'创作1');
INSERT INTO `BlogFolder` VALUES (1,'创作2');
INSERT INTO `BlogFolder` VALUES (1,'创作3');
INSERT INTO `BlogFolder` VALUES (2,'创作4');
INSERT INTO `BlogFolder` VALUES (2,'创作5');
INSERT INTO `BlogFolder` VALUES (2,'创作6');
INSERT INTO `BlogFolder` VALUES (3,'创作7');
INSERT INTO `BlogFolder` VALUES (3,'创作8');
INSERT INTO `BlogFolder` VALUES (3,'创作9');
INSERT INTO `BlogFolder` VALUES (4,'创作10');
INSERT INTO `BlogFolder` VALUES (4,'创作11');
INSERT INTO `BlogFolder` VALUES (4,'创作12');
INSERT INTO `BlogFolder` VALUES (5,'创作13');
INSERT INTO `BlogFolder` VALUES (5,'创作14');
INSERT INTO `BlogFolder` VALUES (5,'创作15');

CREATE TABLE `Favor`(
    `userId` INTEGER,
    `blogId` INTEGER,
    `classification` VARCHAR(64) DEFAULT '',
    CONSTRAINT user_ref_from_favor FOREIGN KEY (`userId`) REFERENCES `User`(userId),
    CONSTRAINT blog_ref_from_favor FOREIGN KEY (`blogId`) REFERENCES `Blog`(blogId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

INSERT INTO `Favor` VALUES (1,10,'喜欢1');
INSERT INTO `Favor` VALUES (1,11,'喜欢1');
INSERT INTO `Favor` VALUES (1,12,'喜欢2');
INSERT INTO `Favor` VALUES (1,13,'喜欢2');
INSERT INTO `Favor` VALUES (1,14,'喜欢3');
INSERT INTO `Favor` VALUES (1,15,'喜欢3');
INSERT INTO `Favor` VALUES (2,19,'喜欢4');
INSERT INTO `Favor` VALUES (2,20,'喜欢4');
INSERT INTO `Favor` VALUES (2,21,'喜欢5');
INSERT INTO `Favor` VALUES (2,22,'喜欢5');
INSERT INTO `Favor` VALUES (2,23,'喜欢6');
INSERT INTO `Favor` VALUES (2,24,'喜欢6');
INSERT INTO `Favor` VALUES (3,28,'喜欢7');
INSERT INTO `Favor` VALUES (3,29,'喜欢7');
INSERT INTO `Favor` VALUES (3,30,'喜欢8');
INSERT INTO `Favor` VALUES (3,31,'喜欢8');
INSERT INTO `Favor` VALUES (3,32,'喜欢9');
INSERT INTO `Favor` VALUES (3,33,'喜欢9');
INSERT INTO `Favor` VALUES (4,37,'喜欢10');
INSERT INTO `Favor` VALUES (4,38,'喜欢10');
INSERT INTO `Favor` VALUES (4,39,'喜欢11');
INSERT INTO `Favor` VALUES (4,40,'喜欢11');
INSERT INTO `Favor` VALUES (4,41,'喜欢12');
INSERT INTO `Favor` VALUES (4,42,'喜欢12');
INSERT INTO `Favor` VALUES (5,1,'喜欢13');
INSERT INTO `Favor` VALUES (5,2,'喜欢13');
INSERT INTO `Favor` VALUES (5,3,'喜欢14');
INSERT INTO `Favor` VALUES (5,4,'喜欢14');
INSERT INTO `Favor` VALUES (5,5,'喜欢15');
INSERT INTO `Favor` VALUES (5,6,'喜欢15');

CREATE TABLE `Comment`(
    `commentId` INTEGER PRIMARY KEY AUTO_INCREMENT,
    `blogId` INTEGER,
    `content` VARCHAR(1024) DEFAULT NULL,
    `reviewer` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT blog_ref_from_comment FOREIGN KEY (`blogId`) REFERENCES `Blog`(blogId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `Comment` VALUES (1,10,'你的文章我好喜欢，放入我的收藏夹喜欢  1  了',1,2);
INSERT INTO `Comment` VALUES (2,12,'你的文章我好喜欢，放入我的收藏夹喜欢  2  了',1,2);
INSERT INTO `Comment` VALUES (3,14,'你的文章我好喜欢，放入我的收藏夹喜欢  3  了',1,2);
INSERT INTO `Comment` VALUES (4,19,'你的文章我好喜欢，放入我的收藏夹喜欢  4  了',2,3);
INSERT INTO `Comment` VALUES (5,21,'你的文章我好喜欢，放入我的收藏夹喜欢  5  了',2,3);
INSERT INTO `Comment` VALUES (6,23,'你的文章我好喜欢，放入我的收藏夹喜欢  6  了',2,3);
INSERT INTO `Comment` VALUES (7,28,'你的文章我好喜欢，放入我的收藏夹喜欢  7  了',3,4);
INSERT INTO `Comment` VALUES (8,30,'你的文章我好喜欢，放入我的收藏夹喜欢  8  了',3,4);
INSERT INTO `Comment` VALUES (9,32,'你的文章我好喜欢，放入我的收藏夹喜欢  9  了',3,4);
INSERT INTO `Comment` VALUES (10,37,'你的文章我好喜欢，放入我的收藏夹喜欢  10  了',4,5);
INSERT INTO `Comment` VALUES (11,39,'你的文章我好喜欢，放入我的收藏夹喜欢  11  了',4,5);
INSERT INTO `Comment` VALUES (12,41,'你的文章我好喜欢，放入我的收藏夹喜欢  12  了',4,5);
INSERT INTO `Comment` VALUES (13,1,'你的文章我好喜欢，放入我的收藏夹喜欢  13  了',5,1);
INSERT INTO `Comment` VALUES (14,3,'你的文章我好喜欢，放入我的收藏夹喜欢  14  了',5,1);
INSERT INTO `Comment` VALUES (15,5,'你的文章我好喜欢，放入我的收藏夹喜欢  15  了',5,1);

CREATE TABLE `Message`(
    `commentId` INTEGER,
    `sender` INTEGER,
    `recipient` INTEGER,
    CONSTRAINT comment_ref_from_message FOREIGN KEY(`commentId`) REFERENCES `Comment`(commentId)
)ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
INSERT INTO `Message` VALUES (1,1,2);
INSERT INTO `Message` VALUES (2,1,2);
INSERT INTO `Message` VALUES (3,1,2);
INSERT INTO `Message` VALUES (4,2,3);
INSERT INTO `Message` VALUES (5,2,3);
INSERT INTO `Message` VALUES (6,2,3);
INSERT INTO `Message` VALUES (7,3,4);
INSERT INTO `Message` VALUES (8,3,4);
INSERT INTO `Message` VALUES (9,3,4);
INSERT INTO `Message` VALUES (10,4,5);
INSERT INTO `Message` VALUES (11,4,5);
INSERT INTO `Message` VALUES (12,4,5);
INSERT INTO `Message` VALUES (13,5,1);
INSERT INTO `Message` VALUES (14,5,1);
INSERT INTO `Message` VALUES (15,5,1);