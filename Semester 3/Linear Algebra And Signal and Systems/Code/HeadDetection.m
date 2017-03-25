image = imread('image.jpg');
%bwimage = rgb2gray(image); 
%imwrite(bwimage, 'bwimage.jpg', 'jpg');
A = im2double(image);

r = A(:,:,1); % Get the RED matrix
g = A(:,:,2); % Get the GREEN matrix
b = A(:,:,3); % Get the BLUE matrix