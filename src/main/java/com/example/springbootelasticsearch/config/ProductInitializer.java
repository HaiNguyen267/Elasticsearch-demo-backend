package com.example.springbootelasticsearch.config;


import com.example.springbootelasticsearch.entity.Product;
import com.example.springbootelasticsearch.repository.ProductMysqlRepo;
import com.example.springbootelasticsearch.search.ProductElasticSearchRepo;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@AllArgsConstructor
public class ProductInitializer implements CommandLineRunner {

    private final ProductMysqlRepo productRepository;
    private final ProductElasticSearchRepo productElasticSearchRepo;


    @Transactional
    @Override
    public void run(String... args) throws Exception {

        List<Product> sampleProducts = List.of(
                new Product("Samsung Galaxy S21 Ultra", "https://th.bing.com/th/id/OIP.3iRYOSf6W5lk-EcweYMnAwHaHY?w=176&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 1199L, "The Samsung Galaxy S21 Ultra is an exceptional flagship smartphone that redefines the boundaries of mobile technology. With its stunning 6.8-inch AMOLED display, every pixel comes to life, offering an immersive visual experience like never before.\n" +
                        "\n" +
                        "Equipped with a powerful Exynos processor, the Galaxy S21 Ultra effortlessly handles multitasking, gaming, and demanding applications, ensuring smooth performance at all times. Its quad-camera setup takes smartphone photography to new heights, allowing you to capture professional-grade photos and videos with incredible detail and clarity.\n" +
                        "\n" +
                        "The phone's design is a testament to elegance and innovation, featuring a sleek and ergonomic build that fits comfortably in your hand. The combination of premium materials and precise craftsmanship enhances both its aesthetics and durability.\n" +
                        "\n" +
                        "Furthermore, the Samsung Galaxy S21 Ultra offers an array of intelligent features, including advanced biometric security measures and an AI-driven virtual assistant, making your daily tasks seamless and secure. With its 5G capability, you can enjoy lightning-fast internet speeds and low-latency connections for smooth streaming and online gaming.\n" +
                        "\n" +
                        "In summary, the Samsung Galaxy S21 Ultra is not just a smartphone; it's a masterpiece of technology, design, and innovation that empowers you to do more, see more, and experience more in the palm of your hand."),
                new Product("Apple iPhone 13 Pro", "https://th.bing.com/th/id/OIP.J6GOghTQd01ppNF-F8hH7AHaGc?w=213&h=185&c=7&r=0&o=5&dpr=1.3&pid=1.7", 1099L, "The Apple iPhone 13 Pro stands as a pinnacle of excellence in the world of smartphones, encompassing cutting-edge technology, sleek design, and unparalleled performance. With its A15 Bionic chip, this device ushers in a new era of speed and efficiency, ensuring seamless multitasking and responsiveness in every application.\n" +
                        "\n" +
                        "Featuring a ProMotion display, the iPhone 13 Pro boasts a refresh rate that adapts to your usage, providing silky-smooth scrolling and enhanced visual experiences. The stunning Super Retina XDR display delivers true-to-life colors, deep blacks, and impressive brightness, making every image and video come alive.\n" +
                        "\n" +
                        "The advanced camera system on the iPhone 13 Pro elevates photography to an art form. With its triple-lens setup, including ultra-wide, wide, and telephoto lenses, you can capture breathtaking shots in various scenarios. The addition of ProRAW and ProRes video recording further empowers photographers and filmmakers to push creative boundaries.\n" +
                        "\n" +
                        "Design-wise, the iPhone 13 Pro exudes elegance and sophistication. Its surgical-grade stainless steel frame is complemented by ceramic shield protection and a refined matte glass back. This combination not only enhances durability but also imparts a premium feel to the device.\n" +
                        "\n" +
                        "Beyond its hardware prowess, the iPhone 13 Pro boasts enhanced privacy features, secure biometric authentication, and an ecosystem that seamlessly integrates with other Apple devices. With its 5G compatibility, you can experience blazing-fast data speeds and enhanced connectivity for all your online activities.\n" +
                        "\n" +
                        "In essence, the Apple iPhone 13 Pro redefines what a smartphone can achieve, fusing advanced technology with artistic expression. It's not just a device; it's a statement of innovation and craftsmanship that empowers you to capture, create, and connect in ways previously unimaginable."),
                new Product("Sony WH-1000XM4 Headphones", "https://th.bing.com/th/id/OIP.B4ZpRhAkszS_lq1SDFfA9gHaHa?w=197&h=197&c=7&r=0&o=5&dpr=1.3&pid=1.7", 349L, "The Sony WH-1000XM4 headphones epitomize the pinnacle of modern audio technology, delivering an immersive auditory experience that transcends ordinary listening. Engineered to perfection, these headphones are a testament to Sony's unwavering commitment to innovation and sound excellence.\n" +
                        "\n" +
                        "At the core of the WH-1000XM4 lies Sony's industry-leading noise cancellation technology. It goes beyond silencing ambient noise; it creates a sanctuary of pure sound, allowing you to immerse yourself completely in your favorite tunes, podcasts, or movies. Whether you're in a bustling city or a crowded airport, the outside world fades away, leaving you with nothing but pristine sound.\n" +
                        "\n" +
                        "These headphones boast High-Resolution Audio, ensuring that every note, every beat, and every whisper is reproduced with astounding clarity and precision. Sony's LDAC technology enables high-quality wireless streaming, allowing you to experience your music in its full splendor, even without a wired connection.\n" +
                        "\n" +
                        "The WH-1000XM4 is designed for comfort as well as performance. Its plush ear cushions and ergonomic design make extended listening sessions a pleasure, while intuitive touch controls put playback, calls, and voice assistants at your fingertips.\n" +
                        "\n" +
                        "With a battery life that can last for hours, you'll be able to enjoy your music without interruption, whether you're on a long flight or a daily commute. And when it's time to recharge, the quick charge feature ensures that a mere few minutes of charging can provide hours of playback.\n" +
                        "\n" +
                        "Whether you're a discerning audiophile, a frequent traveler, or someone who simply appreciates quality sound, the Sony WH-1000XM4 headphones are your passport to a world of auditory bliss. Elevate your listening experience to new heights with a device that sets the bar for wireless audio perfection."),
                new Product("Samsung 4K Smart TV", "https://th.bing.com/th/id/OIP.hFqkm-4nxsxY4W1jVYFViQHaE8?w=262&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 899L, "The Samsung 4K Smart TV redefines the way we experience entertainment, bringing a new dimension of visual brilliance and interactive possibilities to your living room. With cutting-edge technology and sleek design, this TV offers an unparalleled viewing experience that transports you into a realm of lifelike imagery and immersive content.\n" +
                        "\n" +
                        "Immerse yourself in the world of 4K Ultra HD resolution, where every pixel comes to life with stunning clarity and vibrant colors. From the darkest shadows to the brightest highlights, the TV's High Dynamic Range (HDR) technology ensures that you witness a broader spectrum of colors and more realistic details, enhancing your cinematic experience.\n" +
                        "\n" +
                        "But the Samsung 4K Smart TV is not just about exceptional visuals; it's also a gateway to limitless entertainment options. Its smart functionality grants you access to a universe of streaming services, apps, and content. Binge-watch your favorite series, catch up on the latest movies, or explore documentaries from across the globe—all at the touch of a button.\n" +
                        "\n" +
                        "The TV's intuitive interface allows you to navigate effortlessly through menus, customize settings, and discover new content recommendations tailored to your preferences. Seamless integration with voice assistants like Bixby or Alexa offers a hands-free experience, letting you control the TV, search for shows, and manage your smart home devices with simple voice commands.\n" +
                        "\n" +
                        "Connectivity is at the heart of this TV. Multiple HDMI and USB ports provide versatility for gaming consoles, sound systems, and external devices. Share your photos and videos from your smartphone onto the big screen with a tap, or mirror your laptop's display for presentations and productivity.\n" +
                        "\n" +
                        "The Samsung 4K Smart TV is not just a television; it's a window to a world of entertainment and connectivity. Elevate your home theater experience with a device that combines innovation, elegance, and functionality, and immerse yourself in the future of entertainment."),
                new Product("Dell XPS 15 Laptop", "https://th.bing.com/th/id/OIP.JRHvjpVKf7CHEh5Lwg4oOwHaEK?w=330&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 1799L, "The Dell XPS 15 Laptop i combines power, portability, and precision to redefine what a high-performance laptop can achieve. Designed to cater to the needs of professionals, content creators, and tech enthusiasts, this laptop is a true workhorse that excels in every aspect.\n" +
                        "\n" +
                        "At the heart of the Dell XPS 15 is the latest generation Intel Core i processor, providing exceptional speed and performance for demanding tasks. Whether you're editing high-resolution videos, designing intricate graphics, or running resource-intensive software, this laptop effortlessly handles it all.\n" +
                        "\n" +
                        "The laptop's stunning InfinityEdge display showcases visuals with remarkable detail and color accuracy. With virtually borderless edges, the screen maximizes your viewing area while maintaining a compact form factor. The 4K Ultra HD resolution delivers crisp visuals and vivid colors, making it ideal for multimedia consumption and creative work.\n" +
                        "\n" +
                        "Crafted from premium materials, the Dell XPS 15 is as elegant as it is powerful. The aluminum chassis exudes sophistication and durability, while the carbon fiber palm rest adds comfort during extended usage. Backlit keyboard keys provide precision typing even in low-light conditions, enhancing your productivity.\n" +
                        "\n" +
                        "The laptop's connectivity options are equally impressive. Thunderbolt 4 ports offer lightning-fast data transfer speeds and versatile docking capabilities, while USB-C and USB-A ports ensure compatibility with a wide range of devices. Whether you're connecting external displays, peripherals, or storage devices, the Dell XPS 15 has you covered.\n" +
                        "\n" +
                        "Advanced thermal management technology keeps the laptop cool under heavy workloads, ensuring consistent performance without compromising on noise levels. Additionally, the laptop's long battery life ensures that you can stay productive even when you're on the move.\n" +
                        "\n" +
                        "The Dell XPS 15 Laptop i is not just a device; it's a statement of excellence. It embodies the perfect blend of form and function, empowering you to unleash your creativity, accomplish your tasks with precision, and enjoy seamless multitasking, all within a sleek and portable package."),
                new Product("Samsung Galaxy Watch 4", "https://th.bing.com/th/id/OIP.40xFPk1tPif0t9mAV138kgHaI3?w=153&h=183&c=7&r=0&o=5&dpr=1.3&pid=1.7", 249L, "The Samsung Galaxy Watch 4 is a remarkable fusion of advanced technology and elegant design, redefining the way you experience smartwatches. Crafted to seamlessly integrate into your daily life, this wearable offers a plethora of features that enhance your health, connectivity, and convenience.\n" +
                        "\n" +
                        "With a sleek and modern aesthetic, the Galaxy Watch 4 boasts a vibrant circular AMOLED display that delivers crisp visuals and vivid colors. Its touch-sensitive bezel allows you to navigate effortlessly through menus and apps, giving you a more intuitive and immersive user experience.\n" +
                        "\n" +
                        "One of the standout features of the Galaxy Watch 4 is its comprehensive health and wellness tracking capabilities. Equipped with cutting-edge sensors, it monitors your heart rate, sleep patterns, blood oxygen levels, and even tracks your body composition. Whether you're on a fitness journey or aiming for a healthier lifestyle, this smartwatch provides valuable insights to help you achieve your goals.\n" +
                        "\n" +
                        "The Watch 4 seamlessly pairs with your smartphone, enabling you to receive notifications, messages, and calls directly on your wrist. Its built-in microphone and speaker allow you to take calls without reaching for your phone, making multitasking more convenient than ever.\n" +
                        "\n" +
                        "A wide array of fitness and workout features transforms the Galaxy Watch 4 into your personal fitness coach. Choose from various exercise modes, whether it's running, swimming, or yoga, and let the watch track your progress, provide real-time feedback, and offer post-workout summaries to help you stay motivated.\n" +
                        "\n" +
                        "The watch's battery life ensures that it can keep up with your busy day, lasting for multiple days on a single charge. The ability to customize watch faces, bands, and widgets adds a personal touch to your wearable, making it an extension of your style.\n" +
                        "\n" +
                        "Furthermore, the Galaxy Watch 4 is built to withstand the rigors of daily life. It's water-resistant, allowing you to wear it while swimming or in wet conditions, and its durable construction ensures it can handle the demands of an active lifestyle.\n" +
                        "\n" +
                        "In essence, the Samsung Galaxy Watch 4 is more than just a smartwatch; it's a companion that helps you stay connected, healthy, and informed. With its seamless integration of technology and style, it empowers you to take control of your well-being and make the most of every moment."),
                new Product("Sony Alpha a7 III Camera", "https://th.bing.com/th/id/OIP.8d657OMQJXKPu6GFuB-QnQHaHa?w=184&h=184&c=7&r=0&o=5&dpr=1.3&pid=1.7", 1999L, "The Sony Alpha a7 III camera is a game-changer in the world of photography, offering an exceptional combination of performance, versatility, and image quality. Designed for both professional photographers and enthusiasts, this mirrorless camera opens up new creative possibilities and redefines your photography experience.\n" +
                        "\n" +
                        "At the heart of the Sony Alpha a7 III is a full-frame 24.2-megapixel Exmor R CMOS sensor that delivers stunningly detailed images with exceptional dynamic range and low noise performance, even in challenging lighting conditions. Paired with the BIONZ X image processor, the camera offers impressive processing speed and responsiveness, allowing you to capture fleeting moments with precision and clarity.\n" +
                        "\n" +
                        "One of the standout features of the a7 III is its advanced autofocus system. With 693 phase-detection and 425 contrast-detection points, the camera's Fast Hybrid AF system ensures accurate and speedy focusing across the entire frame. Whether you're capturing fast-moving subjects or shooting in low light, the a7 III's autofocus performance is reliable and impressive.\n" +
                        "\n" +
                        "The camera's 5-axis in-body image stabilization (IBIS) system is a true game-changer. It compensates for camera shake across five different axes, allowing you to capture sharp, handheld shots even at slower shutter speeds. This stabilization system is particularly beneficial for shooting in challenging conditions or when using telephoto lenses.\n" +
                        "\n" +
                        "The a7 III's versatility extends beyond still photography. It's also a capable video camera, offering 4K recording with full pixel readout and no pixel binning. This results in high-quality video with exceptional detail and minimal aliasing. The camera's Log profiles provide flexibility in post-production, allowing you to achieve your desired cinematic look.\n" +
                        "\n" +
                        "The camera's ergonomic design and intuitive controls enhance your shooting experience. The high-resolution electronic viewfinder and tilting LCD screen provide flexibility for composing shots from various angles. The robust magnesium alloy body is weather-sealed, providing durability and protection against the elements.\n" +
                        "\n" +
                        "Built-in Wi-Fi and NFC connectivity make it easy to transfer images and videos to your smartphone or tablet for quick sharing on social media or cloud storage. The camera's compatibility with a wide range of Sony E-mount lenses further expands your creative possibilities, from ultra-wide-angle to telephoto and everything in between.\n" +
                        "\n" +
                        "In conclusion, the Sony Alpha a7 III camera is a powerful tool that empowers photographers to push their creative boundaries. With its exceptional image quality, advanced autofocus system, and impressive video capabilities, it's a versatile and reliable companion for capturing both stunning photos and captivating videos. Whether you're a professional or an enthusiast, the a7 III is poised to elevate your photography to new heights."),
                new Product("LG UltraWide Monitor", "https://th.bing.com/th/id/OIP.Wf4llHjH5-RQFWrcZlX5FgHaHa?w=175&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 599L, "The LG UltraWide monitor is a gateway to an immersive visual experience that transcends traditional displays. With its expansive screen real estate and advanced features, this monitor is designed to enhance productivity, entertainment, and creative endeavors.\n" +
                        "\n" +
                        "Featuring a widescreen aspect ratio of 21:9, the LG UltraWide monitor provides ample horizontal space, allowing you to multitask with ease. Whether you're working on complex projects, editing videos, or even gaming, the extended workspace eliminates the need to constantly switch between windows, boosting your efficiency and reducing clutter.\n" +
                        "\n" +
                        "The monitor's stunning image quality is powered by advanced display technologies. With a high-resolution panel and accurate color reproduction, it delivers crisp visuals with vibrant colors and sharp details. The wide color gamut ensures that your content appears true-to-life, making it a valuable tool for photographers, graphic designers, and content creators.\n" +
                        "\n" +
                        "One of the standout features of the LG UltraWide monitor is its ultra-clear panel. With IPS (In-Plane Switching) technology, it provides consistent colors and excellent viewing angles, ensuring that your work looks great from any perspective. Whether you're collaborating with colleagues or sharing content with friends, everyone can enjoy a clear view.\n" +
                        "\n" +
                        "The monitor's large screen real estate is particularly advantageous for creative professionals. Video editors can have their timeline displayed while previewing their work, graphic designers can see their designs in their entirety, and programmers can have multiple lines of code visible simultaneously. This improved workflow minimizes the need for constant scrolling and zooming.\n" +
                        "\n" +
                        "For gamers, the LG UltraWide monitor offers an immersive gaming experience. The wider field of view adds an extra layer of depth to your games, allowing you to see more of the action and immerse yourself in virtual worlds. With support for high refresh rates and adaptive sync technologies, the monitor reduces screen tearing and stuttering for smoother gameplay.\n" +
                        "\n" +
                        "The monitor's ergonomic design further enhances its appeal. Adjustable stands and VESA mounting options ensure that you can find the perfect viewing angle for your comfort. Connectivity options such as HDMI, DisplayPort, and USB-C provide versatility, allowing you to connect various devices and peripherals effortlessly.\n" +
                        "\n" +
                        "In conclusion, the LG UltraWide monitor is a versatile and powerful display that caters to the needs of professionals, creatives, and gamers alike. Its wide screen, stunning image quality, and advanced features empower you to work efficiently, enjoy immersive entertainment, and unleash your creative potential. Whether you're tackling complex projects or indulging in your favorite games, this monitor is a window to a more immersive and productive digital experience."),
                new Product("Samsung SSD 1TB", "https://th.bing.com/th/id/OIP.DNSZq8pACh0umGZU9FtxNgHaE8?w=229&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 149L, "The Samsung SSD 1TB is a game-changing storage solution that elevates your computing experience to new heights. Built upon cutting-edge solid-state drive (SSD) technology, this storage device offers unparalleled performance, reliability, and efficiency, transforming the way you store and access your data.\n" +
                        "\n" +
                        "Gone are the days of waiting for your system to boot up or applications to load. The Samsung SSD 1TB boasts lightning-fast read and write speeds, dramatically reducing boot times and application launch times. Whether you're a professional who needs to work efficiently or a gamer who wants seamless loading into virtual worlds, this SSD ensures you're never held back by sluggish storage.\n" +
                        "\n" +
                        "With a massive 1TB capacity, you have ample room to store your operating system, applications, games, multimedia files, and more. Say goodbye to the constant struggle of managing storage space and deciding what to keep or delete. With this SSD, you can have it all, and the expansive capacity allows you to keep your digital life organized without compromise.\n" +
                        "\n" +
                        "One of the standout features of the Samsung SSD 1TB is its durability. Unlike traditional hard drives, which rely on spinning disks that are susceptible to shocks and vibrations, SSDs utilize solid-state technology. This means there are no moving parts, leading to enhanced shock resistance and reliability. Your data is well-protected, even if your laptop or desktop experiences accidental bumps or falls.\n" +
                        "\n" +
                        "Another advantage of the Samsung SSD 1TB is its energy efficiency. SSDs consume less power compared to traditional hard drives, contributing to longer battery life for laptops and lower electricity bills for desktops. This energy efficiency is especially beneficial for mobile devices, allowing you to use your laptop on the go without constantly worrying about running out of battery.\n" +
                        "\n" +
                        "Data security is a paramount concern in today's digital world. The Samsung SSD 1TB includes advanced security features to keep your data safe. With hardware-based encryption, your sensitive information is protected from unauthorized access. Whether you're storing personal documents, work files, or confidential data, you can have peace of mind knowing your information is secure.\n" +
                        "\n" +
                        "Installing the Samsung SSD 1TB is a breeze, thanks to its compatibility with various systems and form factors. Whether you have a laptop, desktop, or even a gaming console that supports SSDs, you can easily upgrade your storage without the need for advanced technical skills.\n" +
                        "\n" +
                        "In conclusion, the Samsung SSD 1TB is a game-changing storage solution that offers lightning-fast performance, ample capacity, durability, energy efficiency, and advanced security features. Whether you're a professional looking to boost productivity, a gamer seeking faster load times, or anyone in need of reliable and efficient storage, this SSD is the key to unlocking a faster, more responsive computing experience. Say goodbye to slow storage bottlenecks and hello to a new era of speed and efficiency."),
                new Product("Bose QuietComfort Earbuds", "https://th.bing.com/th/id/OIP.1nQ_K6hPi8xSLubYomffxAHaGT?w=205&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 279L, "The Bose QuietComfort Earbuds redefine the way you experience audio. These cutting-edge wireless earbuds offer an immersive sound experience, powerful noise cancellation, and a comfortable fit, making them a must-have companion for music enthusiasts, travelers, and anyone who craves exceptional audio quality.\n" +
                        "\n" +
                        "Immerse yourself in a world of rich, clear sound with the Bose QuietComfort Earbuds. Featuring advanced acoustic technology and proprietary drivers, these earbuds deliver deep, lifelike audio that brings your favorite music, podcasts, and audiobooks to life. Every note, every beat, and every word is reproduced with remarkable clarity and precision, allowing you to hear details you might have missed before.\n" +
                        "\n" +
                        "One of the standout features of these earbuds is their industry-leading noise cancellation. Whether you're on a noisy plane, commuting in a bustling city, or simply trying to focus in a busy environment, the QuietComfort Earbuds work tirelessly to block out distractions. Advanced microphones pick up external sounds and create opposing signals to cancel them out, providing you with a serene listening experience. This noise cancellation technology is customizable, allowing you to adjust the level of isolation to suit your preferences.\n" +
                        "\n" +
                        "Comfort is paramount when it comes to earbuds, and Bose has engineered the QuietComfort Earbuds with all-day wear in mind. The earbuds feature a secure yet gentle seal, ensuring a snug fit that stays in place even during active movement. With multiple ear tip sizes, you can find the perfect fit for your ears, maximizing comfort and audio quality.\n" +
                        "\n" +
                        "The QuietComfort Earbuds offer intuitive touch controls that allow you to navigate through your music, take calls, and interact with your voice assistant without reaching for your phone. This touch control system ensures a seamless and hassle-free experience, putting you in control of your audio environment with a simple tap or swipe.\n" +
                        "\n" +
                        "For those who demand versatility, these earbuds are water and sweat-resistant, making them suitable for workouts, outdoor activities, and everyday use. The earbuds are accompanied by a sleek charging case that not only provides protection but also extends their battery life. With the case, you can enjoy up to 18 hours of playback, ensuring your music is with you every step of the way.\n" +
                        "\n" +
                        "Whether you're a music aficionado, a podcast enthusiast, or someone who simply appreciates superior audio quality, the Bose QuietComfort Earbuds deliver an unparalleled listening experience. With their immersive sound, powerful noise cancellation, comfort-focused design, and long-lasting battery life, these earbuds are an investment in exceptional audio that will elevate your daily life and keep you connected to your favorite content, no matter where you go."),
                new Product("Điện thoại Samsung Galaxy A52", "https://th.bing.com/th/id/OIP.9e8CM5VjpapoLdiCzq1ikgHaHa?w=168&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 499L, "Điện thoại Samsung Galaxy A52 là một chiếc smartphone đẳng cấp với thiết kế tinh tế và hiệu năng mạnh mẽ, mang đến một loạt các tính năng ấn tượng cho trải nghiệm sử dụng hàng ngày.\n" +
                        "\n" +
                        "Với màn hình AMOLED 6.5 inch, Samsung Galaxy A52 cung cấp hình ảnh sống động, màu sắc chân thực và độ tương phản cao. Tận hưởng việc xem phim, chơi game và duyệt web với độ chi tiết rõ nét và góc nhìn rộng.\n" +
                        "\n" +
                        "Camera đa chức năng trên Samsung Galaxy A52 cho phép bạn chụp ảnh chất lượng cao trong mọi tình huống. Camera chính 64MP bắt được mọi khoảnh khắc với độ nét tuyệt vời, trong khi camera siêu rộng 12MP giúp bạn chụp cảnh quan và bức ảnh nhóm hoàn hảo. Camera macro và camera đo độ sâu cung cấp thêm sự sáng tạo cho việc chụp ảnh.\n" +
                        "\n" +
                        "Hiệu suất của Samsung Galaxy A52 được đảm bảo bởi vi xử lý Snapdragon 720G mạnh mẽ, cùng với dung lượng RAM đáng kể. Điều này đảm bảo khả năng xử lý nhanh chóng, mượt mà khi chơi game, xem video và thực hiện nhiều tác vụ cùng lúc.\n" +
                        "\n" +
                        "Pin dung lượng lớn cùng khả năng quản lý tiết kiệm năng lượng giúp Galaxy A52 hoạt động suốt cả ngày mà không cần lo lắng về việc sạc pin liên tục. Tích hợp sạc nhanh giúp bạn nhanh chóng lấy lại năng lượng cho thiết bị trong thời gian ngắn.\n" +
                        "\n" +
                        "Samsung Galaxy A52 cũng mang đến trải nghiệm đáng tin cậy với khả năng chống nước và bụi theo tiêu chuẩn IP67, giúp bảo vệ điện thoại khỏi các tác động từ môi trường xung quanh.\n" +
                        "\n" +
                        "Với tích hợp giao diện One UI 3.0 dựa trên hệ điều hành Android, bạn có thể trải nghiệm giao diện người dùng tinh tế, đồng thời tận hưởng nhiều tính năng tiện ích và tùy chỉnh. Điện thoại Samsung Galaxy A52 là sự kết hợp hoàn hảo giữa thiết kế đẳng cấp, hiệu suất ấn tượng và các tính năng đáng giá, tạo nên một trải nghiệm di động toàn diện cho người dùng."),
                new Product("Máy tính bảng Apple iPad Air", "https://th.bing.com/th/id/OIP.uk-6H32GZC5fnBv0_jSs4QHaHa?w=184&h=185&c=7&r=0&o=5&dpr=1.3&pid=1.7", 699L, "Máy tính bảng Apple iPad Air là sự kết hợp hoàn hảo giữa thiết kế tinh tế, hiệu suất mạnh mẽ và tính năng đa dạng, mang lại trải nghiệm đỉnh cao cho người dùng.\n" +
                        "\n" +
                        "Với màn hình Retina 10.9 inch, iPad Air cung cấp độ phân giải cao và hiển thị màu sắc chân thực, cho phép bạn thưởng thức nội dung đa phương tiện, làm việc và giải trí với chất lượng hình ảnh tuyệt vời. Công nghệ True Tone điều chỉnh màu sắc theo ánh sáng môi trường, giúp màn hình luôn tối ưu.\n" +
                        "\n" +
                        "Được trang bị vi xử lý A14 Bionic, cùng với khả năng tương thích với bút Apple Pencil thế hệ 2 và Magic Keyboard, iPad Air biến thành một công cụ sáng tạo và làm việc mạnh mẽ. Xử lý tác vụ nặng như chỉnh sửa hình ảnh, video, thiết kế đồ họa và chơi game yêu cầu hiệu suất cao trở nên dễ dàng.\n" +
                        "\n" +
                        "Hệ điều hành iPadOS cung cấp môi trường làm việc đa nhiệm, cho phép bạn mở nhiều ứng dụng cùng lúc, thậm chí cả trong chế độ Slide Over và Split View. Điều này tăng khả năng sản xuất và hiệu suất làm việc của bạn.\n" +
                        "\n" +
                        "Với hỗ trợ cho Apple Pencil thế hệ 2, bạn có thể viết, vẽ và tương tác trực tiếp trên màn hình của iPad Air với độ nhạy cảm cao và độ trễ thấp. Magic Keyboard mang lại trải nghiệm gõ phím tương tự laptop, cùng với trackpad giúp điều hướng dễ dàng.\n" +
                        "\n" +
                        "Với thiết kế mỏng nhẹ và viên pin dung lượng cao, iPad Air có thời lượng sử dụng lâu dài và dễ dàng mang đi khắp nơi. Được trang bị cổng USB-C, bạn có thể kết nối với các thiết bị và phụ kiện một cách tiện lợi.\n" +
                        "\n" +
                        "Tóm lại, máy tính bảng Apple iPad Air là sự lựa chọn hoàn hảo cho những người muốn sở hữu một thiết bị đa năng, mạnh mẽ và sang trọng, để làm việc, học tập và giải trí một cách tối ưu."),
                new Product("Tai nghe không dây Sony WF-1000XM4", "https://th.bing.com/th/id/OIP.v7JWVlazSxawWPXqeg6dmwHaHa?w=89&h=89&c=1&rs=1&qlt=90&r=0&dpr=1.3&pid=InlineBlock", 299L, "Tai nghe không dây Sony WF-1000XM4 mang đến trải nghiệm âm thanh tuyệt vời và khả năng chống ồn xuất sắc, đem lại sự tận hưởng đích thực cho người dùng.\n" +
                        "\n" +
                        "Với công nghệ chống ồn tương tự như trong dòng tai nghe over-ear của Sony, WF-1000XM4 giúp loại bỏ tối đa tiếng ồn từ môi trường xung quanh. Điều này cho phép bạn tập trung vào âm nhạc yêu thích, cuộc trò chuyện hay công việc mà không bị xao lãng bởi tiếng ồn ngoại vi.\n" +
                        "\n" +
                        "Amplifier giúp cải thiện chất lượng âm thanh, mang đến âm trầm sâu và chất lượng cao ở các dải tần số khác nhau. Tai nghe hỗ trợ LDAC, một công nghệ truyền tải âm thanh không dây hi-res, cho phép bạn thưởng thức nhạc ở chất lượng cao ngay cả khi sử dụng Bluetooth.\n" +
                        "\n" +
                        "Thiết kế nhỏ gọn và thoải mái của tai nghe WF-1000XM4 giúp chúng phù hợp tốt trong tai và không gây đau hay khó chịu sau thời gian sử dụng. Chúng cũng có khả năng chống nước và mồ hôi, phù hợp cho cả việc sử dụng hàng ngày và khi tập thể dục.\n" +
                        "\n" +
                        "Ứng dụng đi kèm với tai nghe cho phép bạn tùy chỉnh cài đặt âm thanh, tùy chỉnh chức năng chống ồn và theo dõi tình trạng pin. Thậm chí, tai nghe còn hỗ trợ tính năng thay đổi chức năng chống ồn dựa trên môi trường xung quanh, giúp bạn tối ưu hóa trải nghiệm nghe nhạc.\n" +
                        "\n" +
                        "Pin của WF-1000XM4 cung cấp thời gian sử dụng lâu dài, cho phép bạn thưởng thức âm nhạc và cuộc gọi trong suốt nhiều giờ liền. Hộp sạc đi kèm cũng có khả năng sạc nhanh, giúp bạn không bao giờ bị gián đoạn khỏi âm nhạc yêu thích.\n" +
                        "\n" +
                        "Tóm lại, tai nghe không dây Sony WF-1000XM4 là sự kết hợp hoàn hảo giữa chất lượng âm thanh tuyệt vời, khả năng chống ồn xuất sắc và thiết kế thoải mái, là sự lựa chọn lý tưởng cho những người muốn tận hưởng âm nhạc trong không gian riêng tư và thoải mái."),
                new Product("Laptop Dell Inspiron 14", "https://th.bing.com/th/id/OIP.NOh9EcFXrTXT0SWBlBHygQHaE6?w=240&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 999L, "Smart TV 4K Samsung 55 inch mang đến trải nghiệm giải trí tuyệt vời với chất lượng hình ảnh sắc nét và tính năng thông minh đa dạng.\n" +
                        "\n" +
                        "Với độ phân giải 4K Ultra HD, TV này cung cấp hình ảnh chất lượng cao với độ chi tiết tốt hơn và màu sắc sống động hơn. Bạn có thể thưởng thức những bộ phim, chương trình truyền hình, hay thậm chí trò chơi video với độ rõ nét tuyệt đẹp.\n" +
                        "\n" +
                        "Tích hợp hệ điều hành thông minh, Smart TV này cho phép bạn truy cập vào nhiều ứng dụng giải trí như Netflix, YouTube, Spotify và nhiều nội dung khác. Bạn có thể dễ dàng xem video, nghe nhạc, chơi game và tận hưởng hàng ngàn nội dung giải trí trực tuyến.\n" +
                        "\n" +
                        "Cổng kết nối đa dạng trên TV cho phép bạn kết nối nhiều thiết bị khác nhau như đầu phát HD, máy chơi game, và hệ thống âm thanh để trải nghiệm giải trí một cách đa dạng hơn.\n" +
                        "\n" +
                        "Khả năng điều khiển bằng giọng nói giúp bạn dễ dàng thay đổi kênh, tìm kiếm nội dung hoặc thậm chí điều khiển các thiết bị khác trong hệ thống giải trí của bạn.\n" +
                        "\n" +
                        "Kích thước 55 inch của TV tạo ra một trải nghiệm hấp dẫn cho việc xem phim và thể thao, đồng thời không quá lớn để phù hợp với nhiều không gian phòng khách.\n" +
                        "\n" +
                        "Tóm lại, Smart TV 4K Samsung 55 inch là một sự kết hợp hoàn hảo giữa chất lượng hình ảnh xuất sắc, tính năng thông minh đa dạng và khả năng tương tác thông qua giọng nói, đem lại trải nghiệm giải trí đỉnh cao cho gia đình và bạn bè."),
                new Product("Đồng hồ thông minh Xiaomi Mi Watch", "https://th.bing.com/th/id/OIP.aP0EHDB9WokjkP5jMpVLUwHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7", 159L, "Smart TV 4K Samsung 55 inch mang đến trải nghiệm giải trí tuyệt vời với chất lượng hình ảnh sắc nét và tính năng thông minh đa dạng.\n" +
                        "\n" +
                        "Với độ phân giải 4K Ultra HD, TV này cung cấp hình ảnh chất lượng cao với độ chi tiết tốt hơn và màu sắc sống động hơn. Bạn có thể thưởng thức những bộ phim, chương trình truyền hình, hay thậm chí trò chơi video với độ rõ nét tuyệt đẹp.\n" +
                        "\n" +
                        "Tích hợp hệ điều hành thông minh, Smart TV này cho phép bạn truy cập vào nhiều ứng dụng giải trí như Netflix, YouTube, Spotify và nhiều nội dung khác. Bạn có thể dễ dàng xem video, nghe nhạc, chơi game và tận hưởng hàng ngàn nội dung giải trí trực tuyến.\n" +
                        "\n" +
                        "Cổng kết nối đa dạng trên TV cho phép bạn kết nối nhiều thiết bị khác nhau như đầu phát HD, máy chơi game, và hệ thống âm thanh để trải nghiệm giải trí một cách đa dạng hơn.\n" +
                        "\n" +
                        "Khả năng điều khiển bằng giọng nói giúp bạn dễ dàng thay đổi kênh, tìm kiếm nội dung hoặc thậm chí điều khiển các thiết bị khác trong hệ thống giải trí của bạn.\n" +
                        "\n" +
                        "Kích thước 55 inch của TV tạo ra một trải nghiệm hấp dẫn cho việc xem phim và thể thao, đồng thời không quá lớn để phù hợp với nhiều không gian phòng khách.\n" +
                        "\n" +
                        "Tóm lại, Smart TV 4K Samsung 55 inch là một sự kết hợp hoàn hảo giữa chất lượng hình ảnh xuất sắc, tính năng thông minh đa dạng và khả năng tương tác thông qua giọng nói, đem lại trải nghiệm giải trí đỉnh cao cho gia đình và bạn bè."),
                new Product("Máy ảnh Sony Cyber-shot RX100", "https://th.bing.com/th/id/OIP.c3-jFn5N3Y_adyggStVC8QHaHa?w=201&h=201&c=7&r=0&o=5&dpr=1.3&pid=1.7", 799L, "Máy ảnh Sony Cyber-shot RX100 là một chiếc máy ảnh nhỏ gọn nhưng mạnh mẽ, mang lại chất lượng ảnh đẳng cấp và khả năng điều khiển linh hoạt. Với thiết kế nhỏ gọn, RX100 rất thuận tiện để mang theo bất cứ nơi đâu, giúp bạn bắt lấy những khoảnh khắc đáng nhớ mọi lúc.\n" +
                        "\n" +
                        "Máy ảnh này được trang bị cảm biến ảnh 1 inch Exmor CMOS, cho phép nắm bắt mức độ chi tiết và độ phân giải cao trong mọi tình huống ánh sáng. Ống kính Zeiss của RX100 có khả năng zoom quang học tốt, giúp bạn chụp từ góc rộng đến telephoto mà không mất đi chất lượng ảnh.\n" +
                        "\n" +
                        "Hệ thống lấy nét tự động nhanh chóng và chính xác, giúp bạn bắt lấy những khoảnh khắc động và tĩnh một cách dễ dàng. Chế độ chụp RAW cho phép bạn tùy chỉnh và chỉnh sửa ảnh sau khi chụp mà không mất đi chi tiết.\n" +
                        "\n" +
                        "Màn hình LCD 3 inch ở phía sau giúp bạn xem trước và chỉnh sửa ảnh một cách tiện lợi. RX100 cũng hỗ trợ quay video chất lượng cao, cho phép bạn ghi lại những đoạn video sắc nét và chất lượng.\n" +
                        "\n" +
                        "Tóm lại, máy ảnh Sony Cyber-shot RX100 là sự kết hợp tuyệt vời giữa kích thước nhỏ gọn và khả năng chụp ảnh đáng tin cậy, là một công cụ hoàn hảo cho những người đam mê nhiếp ảnh và muốn mang theo máy ảnh mọi lúc mọi nơi."),
                new Product("Màn hình LG 27 inch", "https://th.bing.com/th/id/OIP.1D7z0-84A_U-YXJ_HPHKHAHaFj?w=274&h=206&c=7&r=0&o=5&dpr=1.3&pid=1.7", 349L, "Màn hình LG 27 inch mang đến trải nghiệm hiển thị tuyệt vời với kích thước lớn và độ phân giải cao. Với màn hình kích thước 27 inch, bạn sẽ được thưởng thức hình ảnh rộng lớn và chi tiết sắc nét, tạo ra không gian làm việc và giải trí tốt hơn.\n" +
                        "\n" +
                        "Độ phân giải cao của màn hình giúp hình ảnh trở nên sắc nét và chi tiết, phù hợp cho việc làm việc, đọc sách, xem phim, hoặc thậm chí chỉ đơn giản là lướt web. Công nghệ màn hình IPS của LG đảm bảo góc nhìn rộng và màu sắc chính xác, giúp bạn có trải nghiệm hiển thị tốt từ mọi góc độ.\n" +
                        "\n" +
                        "Màn hình LG 27 inch cũng có khả năng hiển thị màu sắc rực rỡ và tương phản động, tạo ra hình ảnh sống động và sống động. Điều này rất quan trọng khi bạn tham gia vào các hoạt động sáng tạo như chỉnh sửa hình ảnh, xem phim hoặc chơi game.\n" +
                        "\n" +
                        "Việc có màn hình lớn như thế này cũng giúp tăng cường năng suất làm việc. Bạn có thể mở nhiều cửa sổ ứng dụng cùng lúc và dễ dàng làm việc trên màn hình rộng.\n" +
                        "\n" +
                        "Tóm lại, màn hình LG 27 inch là một lựa chọn tốt cho những người cần một trải nghiệm hiển thị tốt hơn với độ phân giải cao, màu sắc chính xác và kích thước lớn, phục vụ cả công việc và giải trí."),
                new Product("Ổ cứng SSD Samsung 500GB", "https://th.bing.com/th/id/OIP.b1tK2-htW22NCIqh3BvG5gHaHa?w=89&h=89&c=1&rs=1&qlt=90&r=0&dpr=1.3&pid=InlineBlock", 99L, "Ổ cứng SSD Samsung dung lượng 500GB là một giải pháp tốt để nâng cấp và tối ưu hóa hiệu suất lưu trữ của máy tính hoặc thiết bị của bạn. Với dung lượng lưu trữ 500GB, bạn sẽ có đủ không gian để lưu trữ hệ điều hành, các ứng dụng quan trọng và dữ liệu cá nhân mà không cần lo ngại về việc không đủ dung lượng.\n" +
                        "\n" +
                        "Ổ cứng SSD (Solid State Drive) của Samsung được thiết kế với công nghệ tiên tiến, giúp cải thiện tốc độ truy cập dữ liệu so với ổ cứng cơ học truyền thống. Bạn sẽ thấy máy tính khởi động nhanh hơn, các ứng dụng mở lên một cách nhanh chóng và tốc độ sao lưu, di chuyển và truy cập dữ liệu cũng được cải thiện đáng kể.\n" +
                        "\n" +
                        "Đặc biệt, việc sử dụng ổ cứng SSD cũng giúp tiết kiệm năng lượng và làm giảm tiếng ồn từ máy tính, vì không có bộ phận cơ học di chuyển như trong ổ cứng cơ học.\n" +
                        "\n" +
                        "Samsung là một trong những thương hiệu nổi tiếng và đáng tin cậy trong lĩnh vực lưu trữ. Ổ cứng SSD Samsung 500GB đảm bảo tính ổn định và độ bền cao, giúp bạn an tâm sử dụng trong thời gian dài mà không cần lo ngại về sự cố hỏng hóc.\n" +
                        "\n" +
                        "Tóm lại, ổ cứng SSD Samsung dung lượng 500GB là một sự lựa chọn xuất sắc để cải thiện hiệu suất lưu trữ của máy tính hoặc thiết bị của bạn, đem lại trải nghiệm nhanh chóng, ổn định và tiết kiệm năng lượng."),
                new Product("Tai nghe chống ồn Bose 700", "https://th.bing.com/th/id/OIP.v39lANpA9sAZvqLwXyThKgHaHa?w=199&h=199&c=7&r=0&o=5&dpr=1.3&pid=1.7", 349L, "Tai nghe chống ồn Bose 700 là một sản phẩm đột phá trong việc mang lại trải nghiệm âm thanh tốt nhất và khả năng chống ồn xuất sắc. Với thiết kế hiện đại, tích hợp công nghệ tiên tiến và chất lượng âm thanh đỉnh cao, chiếc tai nghe này mang đến một trải nghiệm nghe nhạc và gọi điện hoàn toàn mới mẻ.\n" +
                        "\n" +
                        "Bose 700 được trang bị công nghệ chống ồn đẳng cấp, cho phép bạn tận hưởng âm nhạc mà không bị phiền nhiễu bởi tiếng ồn từ môi trường xung quanh. Từ tiếng ồn đường phố đến tiếng ồn trong máy bay, tai nghe này có khả năng lọc bỏ mọi âm thanh không mong muốn, tạo ra không gian yên tĩnh để bạn tập trung hoàn toàn vào âm nhạc.\n" +
                        "\n" +
                        "Không chỉ là công cụ nghe nhạc, tai nghe Bose 700 còn có tích hợp microphone đa hướng và công nghệ hủy tiếng ồn trong cuộc gọi, giúp bạn duy trì cuộc trò chuyện trong môi trường ồn ào mà không cần phải nâng giọng.\n" +
                        "\n" +
                        "Thiết kế của Bose 700 rất thoải mái, với cốc tai êm ái và dải đeo đầu mềm mại. Bạn có thể đeo tai nghe trong thời gian dài mà không cảm thấy mệt mỏi.\n" +
                        "\n" +
                        "Tóm lại, tai nghe chống ồn Bose 700 là sự kết hợp hoàn hảo giữa âm thanh tuyệt vời, khả năng chống ồn xuất sắc và thiết kế thoải mái. Cho dù bạn đang nghe nhạc hay thực hiện cuộc gọi, tai nghe này sẽ đem đến trải nghiệm đỉnh cao và không gì có thể so sánh được."),
                new Product("Laptop Dell XPS 13", "https://th.bing.com/th/id/OIP.aU7tmFAq4W19NA4PpPKuIgHaEK?w=279&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 159L, "Laptop Dell XPS 13 mỏng nhẹ với hiệu suất ấn tượng, là công cụ hoàn hảo cho công việc và giải trí."),
                new Product("Điện thoại iPhone 13", "https://th.bing.com/th/id/OIP.D2L5Emr_tkvju5Hilr22DgHaHa?w=189&h=189&c=7&r=0&o=5&dpr=1.3&pid=1.7", 799L, "Điện thoại iPhone 13 là một tác phẩm đỉnh cao của công nghệ và thiết kế từ Apple. Với thiết kế tinh tế và vật liệu cao cấp, chiếc điện thoại này không chỉ là một công cụ thông tin mà còn là biểu tượng của phong cách và đẳng cấp.\n" +
                        "\n" +
                        "Bên trong, iPhone 13 được trang bị vi xử lý A15 Bionic mạnh mẽ, mang đến hiệu suất vượt trội cho cả tác vụ đa nhiệm và chơi game. Màn hình Super Retina XDR sắc nét và sáng rực rỡ, giúp bạn trải nghiệm hình ảnh và video chất lượng cao.\n" +
                        "\n" +
                        "Hệ thống camera tiên tiến trên iPhone 13 cho phép bạn chụp ảnh chất lượng chuyên nghiệp và quay video ấn tượng. Chế độ Night mode giúp bạn chụp ảnh trong điều kiện ánh sáng yếu mà vẫn giữ được độ chi tiết và màu sắc tự nhiên.\n" +
                        "\n" +
                        "iPhone 13 cũng có khả năng chống nước và chống bụi, giúp bảo vệ thiết bị trong môi trường khắc nghiệt. Dung lượng pin cải thiện giúp bạn sử dụng điện thoại cả ngày mà không cần lo lắng về việc hết pin.\n" +
                        "\n" +
                        "Hệ điều hành iOS của Apple cung cấp trải nghiệm mượt mà và bảo mật cao, với nhiều tính năng độc quyền và ứng dụng đa dạng trên App Store.\n" +
                        "\n" +
                        "Tóm lại, iPhone 13 không chỉ là một chiếc điện thoại thông thường, mà là một tác phẩm nghệ thuật kết hợp giữa thiết kế tinh tế, hiệu suất mạnh mẽ và hệ thống camera đa dạng, mang đến trải nghiệm tuyệt vời cho người dùng."),
                new Product("Máy tính bảng Samsung Galaxy Tab S7", "https://th.bing.com/th/id/OIP.SvWqMUNLJkrcGBn2LhQvkQHaGk?w=170&h=180&c=7&r=0&o=5&dpr=1.3&pid=1.7", 349L, "Máy tính bảng Samsung Galaxy Tab S7 là một thiết bị đa năng và mạnh mẽ, giúp bạn làm việc, giải trí và sáng tạo mọi lúc mọi nơi. Với thiết kế sang trọng và màn hình AMOLED sắc nét, Tab S7 mang đến trải nghiệm độc đáo và tiện ích.\n" +
                        "\n" +
                        "Với bút cảm ứng S Pen đi kèm, bạn có thể viết, vẽ và ghi chú một cách tự nhiên trên màn hình, tạo ra những tác phẩm sáng tạo và tương tác hiệu quả. Đặc biệt, tần số quét cao của bút giúp tạo ra cảm giác như viết trên giấy thực sự.\n" +
                        "\n" +
                        "Hiệu suất của Galaxy Tab S7 được đảm bảo bởi vi xử lý mạnh mẽ và dung lượng RAM lớn, giúp bạn xử lý các tác vụ nặng như đồ họa, chơi game và chỉnh sửa video một cách dễ dàng. Hệ điều hành Android cùng với giao diện Samsung One UI tùy chỉnh mang lại trải nghiệm mượt mà và tiện ích.\n" +
                        "\n" +
                        "Máy tính bảng này cũng hỗ trợ kết nối 5G, giúp bạn duyệt web, xem video và làm việc trực tuyến với tốc độ nhanh chóng. Hệ thống loa âm thanh đa chiều AKG cùng với âm thanh âm mô phong từ Dolby Atmos mang đến trải nghiệm giải trí đỉnh cao.\n" +
                        "\n" +
                        "Với Galaxy Tab S7, bạn có thể làm việc hiệu quả, giải trí thú vị và sáng tạo không giới hạn, tận dụng tối đa tiềm năng của một máy tính bảng cao cấp."),
                new Product("Laptop ASUS ROG Strix G15", "https://th.bing.com/th/id/OIP.-XgBNsgbrOroHMJcNY9o9gHaFU?pid=ImgDet&rs=1", 99L, "Nâng cấp không gian lưu trữ với ổ cứng SSD Samsung 500GB tốc độ cao.")
        );

        if (productRepository.count() == 0) {
            // Insert products only if the table is empty
            productRepository.saveAll(sampleProducts);
            productElasticSearchRepo.saveAll(sampleProducts);
            System.out.println("Sample products inserted into the database.");
        }
    }

}