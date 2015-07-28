class 1356 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect67
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSizeScale=True
		EffectClass=Class'LineageEffect.sp_prophecy_of_fire_ca'
	End Object
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect68
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-1.000000)
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.sp_prophecy_of_fire_ta'
		bOnMultiTarget=True
	End Object
	Desc="프로피시 오브 파이어" //Sea of ​​Fire PROFIBUS
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect67',SpecificStage=0)
	ShotActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect68',SpecificStage=0)
}