globl:.main

.data
v0:.word 3,5,8,10,1
vL:.word 5
v1:.word 1,2,3,0,13

.text
main:

la $t0, v0
la $t1, v1
lw $t2, vL



xor $t3,$t3,$t3
xor $t4,$t4,$t4


jal prodottoScalare


add $a0, $t4, $zero

li $v0, 1
syscall

li $v0, 10
syscall



prodottoScalare:

for:
	beq $t3, $t2, end
	
	lw $t8 ,4($t0)
	lw $t9 ,4($t1)
	mul $t5 ,$t8,$t9
	add $t4, $t4, $t5
	addi $t3, $t3, 1
	
	j for
	
	
	
	
end:

jr $ra
