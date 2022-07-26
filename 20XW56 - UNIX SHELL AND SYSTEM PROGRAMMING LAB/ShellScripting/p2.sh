echo "Enter First file name" read file1
echo " Enter Second file name" read file2
if [ -e $file1 ] then
cat $file1 >> $file2
else
echo " $file1 does not exist"
fi
echo " $file1 content:" cat $file1
echo " $file2 content:" cat $file2
