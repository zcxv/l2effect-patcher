class 5014 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect10
		AttachOn=AM_LA
		offset=(X=-1.000000,Y=0.000000,Z=0.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.mb_frintessa_normal_a_ta'
		bOnMultiTarget=True
	End Object
	Desc="프린테사악마일반공격" //Peurintesa demon general attack
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect10',SpecificStage=0)
}