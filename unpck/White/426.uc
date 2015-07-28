class 426 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect27
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-0.850000)
		EffectClass=Class'LineageEffect.s_u806_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect29
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		EffectClass=Class'LineageEffect.s_u806_cs'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect34
		AttachOn=AM_LA
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.s_u806_ta'
	End Object
	Desc="배틀 스탠스" //Battle Stance
	CastingActions(0)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect27',SpecificStage=0)
	CastingActions(1)=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect29',SpecificStage=0)
	ChannelingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect34',SpecificStage=0)
}