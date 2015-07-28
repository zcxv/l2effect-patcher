class 5111 extends SkillVisualEffect;

defaultproperties
{
	Begin Object Class=SkillAction_LocateEffect Name=SkillAction_LocateEffect44
		AttachOn=AM_LA
		offset=(X=0.000000,Y=0.000000,Z=-25.000000)
		bRelativeToCylinder=False
		bSpawnOnTarget=True
		EffectClass=Class'LineageEffect.wh_recharge_ta'
	End Object
	Desc="원시의섬퀘스트연출" //Raw produce of the island quest
	CastingActions=(Action=SkillAction_LocateEffect'SkillAction_LocateEffect44',SpecificStage=0)
}