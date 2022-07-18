echo "good morning"
echo "Menu"
echo "1. ls"
echo "2. pwd"
read -p "Enter you choice: " ch
case $ch in
1) ls;;
2) pwd;;
esac
