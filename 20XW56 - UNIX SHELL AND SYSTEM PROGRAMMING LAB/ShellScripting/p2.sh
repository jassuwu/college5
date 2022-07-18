if [$# -ne 2]; then
	echo "Enter 2 args."
	exit
fi
echo "The args are: "
for i in $@
do
	cat $i
done
if [ -e $1]; then
	cp $1 $2
fi
