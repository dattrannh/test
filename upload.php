<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form method="post" action="upload.php" enctype="multipart/form-data">
            <input type="file" name="image" />
            <input type="submit" value="Upload" name="upload"/>
            <br/>
             
            <?php 
                // XỬ LÝ KHI SUBMIT
				
				
				
							/*
			// Đường dẫn upload
			$uploadpath = "upload/";
			 
			// Nhận thông tin
			$filedata = $_FILES['filedata']['tmp_name'];
			$filename = $_POST['filename'];
			 
			 
			if ($filedata != '' && $filename != ''){
				// Dùng hàm copy để lưu vào thay vì hàm move_upload_file như thông thường
				copy($filedata,$uploadpath.$filename);   
			}*/
            ?>
             
        </form>
    </body>
</html>

